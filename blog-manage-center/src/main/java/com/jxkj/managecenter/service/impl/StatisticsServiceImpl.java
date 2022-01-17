package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxkj.common.constant.BlogStatusConstant;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.util.DateFormatConvertUtil;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.entity.BlogLikeUser;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.mapper.FavoritesMapper;
import com.jxkj.managecenter.repository.RedisRepository;
import com.jxkj.managecenter.service.StatisticsService;
import com.jxkj.managecenter.vo.ArchiveMonthVO;
import com.jxkj.managecenter.vo.ArchiveVO;
import com.jxkj.managecenter.vo.ChartPageViewVO;
import com.jxkj.managecenter.vo.ChartVO;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public ResultBody allStatistics(Long userId) {
        List<BlogInfo> blogInfos = redisRepository.getObject("blogInfoDetails");
        // 统计原创数
        long countType = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId) && "原创".equals(blogInfo.getBlogType().getType()))
                .count();
        // 待定
        long countLikeNum01 = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .mapToInt(BlogInfo::getLikeNum)
                .sum();
        // 访问数
        long countPageViewNum = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .mapToInt(BlogInfo::getPageViewNum)
                .sum();

        // 博客被点赞数
        List<List<BlogLikeUser>> collect = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .map(BlogInfo::getBlogLikeUsers)
                .collect(Collectors.toList());
        List<BlogLikeUser> likeUsers = new ArrayList<>();
        for (List<BlogLikeUser> blogLikeUsers : collect) {
            likeUsers.addAll(blogLikeUsers);
        }
        long countLikeNum = likeUsers.size();

        // 博客被收藏数
        List<List<Favorites>> collect1 = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .map(BlogInfo::getFavorites)
                .collect(Collectors.toList());

        List<Favorites> favorites01 = new ArrayList<>();
        for (List<Favorites> favorites : collect1) {
            for (Favorites favorite : favorites) {
                if (favorite.getId() != null) {
                    favorites01.add(favorite);
                }
            }
        }
        long countFavorites = favorites01.size();
        Map<String, Object> statistics = new ConcurrentHashMap<>(16);
        statistics.put("countType", countType);
        // statistics.put("countLikeNum01", countLikeNum01);
        statistics.put("countPageViewNum", countPageViewNum);
        statistics.put("countLikeNum", countLikeNum);
        statistics.put("countFavorites", countFavorites);
        return ResultBodyUtil.success(statistics);
    }

    @Override
    public ResultBody countBlogNumber(Long userId) {
        QueryWrapper<BlogInfo> queryWrapper = Wrappers.query();
        queryWrapper.eq("t_user_id", userId);
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);
        int size = blogInfos.size();
        return ResultBodyUtil.success(size);
    }

    @Override
    public ResultBody countForChart() {
        List<ChartVO> chartVOS = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date start = null;
        Date end = null;
        try {
            start = DateFormatConvertUtil.asDate(LocalDate.now().minusDays(7));
            end = DateFormatConvertUtil.asDate(LocalDate.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!start.equals(end)) {
            calendar.setTime(start);
            String strStartTime = sdf.format(start);
            LocalDateTime startTime = DateFormatConvertUtil.startTime(strStartTime);
            LocalDateTime endTime = DateFormatConvertUtil.endTime(strStartTime);
            QueryWrapper<BlogInfo> queryWrapper = Wrappers.query();
            queryWrapper.between("create_time", startTime, endTime);
            List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);
            ChartVO chartVO = new ChartVO();
            chartVO.setDate(strStartTime);
            chartVO.setBlogTodayNum(blogInfos.size());
            chartVOS.add(chartVO);
            calendar.add(Calendar.DATE, 1);
            start = calendar.getTime();
        }
        return ResultBodyUtil.success(chartVOS);
    }

    @Override
    public ResultBody countPageViewForChart(Long userId) {
        List<ChartPageViewVO> chartPageViewVOS = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date start = null;
        Date end = null;
        try {
            start = DateFormatConvertUtil.asDate(LocalDate.now().minusDays(7));
            end = DateFormatConvertUtil.asDate(LocalDate.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!start.equals(end)) {
            calendar.setTime(start);
            String strStartTime = sdf.format(start);
            LocalDateTime startTime = DateFormatConvertUtil.startTime(strStartTime);
            LocalDateTime endTime = DateFormatConvertUtil.endTime(strStartTime);
            QueryWrapper<BlogInfo> queryWrapper = Wrappers.query();
            queryWrapper.eq("t_user_id", userId).between("create_time", startTime, endTime);
            List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);
            Integer countPageViewNum = blogInfos.stream()
                    .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                    .mapToInt(BlogInfo::getPageViewNum)
                    .sum();
            ChartPageViewVO chartPageViewVO = new ChartPageViewVO();
            chartPageViewVO.setDate(strStartTime);
            chartPageViewVO.setPageViewNum(countPageViewNum);
            chartPageViewVOS.add(chartPageViewVO);
            calendar.add(Calendar.DATE, 1);
            start = calendar.getTime();
        }
        return ResultBodyUtil.success(chartPageViewVOS);
    }

    @Override
    public ResultBody getOneBlogStatistics(Long blogId) {
        BlogInfo blogInfo = blogInfoMapper.findBlogInfoAndTagsByBlogInfoId(blogId);
        Integer pageViewNum = blogInfo.getPageViewNum();
        List<BlogLikeUser> blogLikeUsers = blogInfo.getBlogLikeUsers();
        Integer blogLinkNum = blogLikeUsers.size();
        List<Favorites> favorites = blogInfo.getFavorites();
        Integer favoritesNum = favorites.size();
        Map<String, Object> map = new ConcurrentHashMap<>(16);
        map.put("pageViewNum", pageViewNum);
        map.put("blogLinkNum", blogLinkNum);
        map.put("favoritesNum", favoritesNum);
        return ResultBodyUtil.success(map);
    }

    @Override
    public ResultBody countBlogArchive(Long userId) {
        List<ArchiveVO> archiveVOS = new ArrayList<>();
        BlogInfo oldOneBlog = blogInfoMapper.findOldOneBlog(userId);
        BlogInfo recentlyOneBlog = blogInfoMapper.findRecentlyOneBlog(userId);
        LocalDateTime startTime = oldOneBlog.getCreateTime();
        LocalDateTime endTime = recentlyOneBlog.getCreateTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Date start = DateFormatConvertUtil.asDate(startTime);
        Date end = DateFormatConvertUtil.asDate(endTime);
        String strStartTime = sdf.format(start);
        String strEndTime = sdf.format(end);
        Integer strS = Integer.valueOf(strStartTime.substring(0, 4));
        Integer strE = Integer.valueOf(strEndTime.substring(0, 4));
        while (strS <= strE) {
            ArchiveVO archiveVO = new ArchiveVO();
            List<ArchiveMonthVO> archiveMonthVOS = new ArrayList<>();
            Integer ss = strS;
            String sss = ss.toString();
            archiveVO.setArchiveYear(sss);
            Date compareStart = null;
            Date compareEnd = null;
            try {
                compareStart = sdfMonth.parse(strStartTime);
                compareEnd = sdfMonth.parse(strEndTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
                /*calendar2.setTime(compareEnd);
                calendar2.add(Calendar.MONTH, +1);
                compareEnd = calendar2.getTime();*/
            while (compareStart.compareTo(compareEnd) <= 0) {
                ArchiveMonthVO archiveMonthVO = new ArchiveMonthVO();
                calendar1.setTime(compareStart);
                String strStartT = sdfMonth.format(compareStart);
                //String newStrStart = strStartT.substring(0, 7);
                String strMonth = strStartT.substring(5, 7);
                Integer integer = blogInfoMapper.countBlogNumberByUserId(strStartT, userId);
                archiveMonthVO.setArchiveMonth(strMonth);
                archiveMonthVO.setBlogNumber(integer);
                calendar1.add(Calendar.MONTH, +1);
                compareStart = calendar1.getTime();
                archiveMonthVOS.add(archiveMonthVO);
            }
            strS++;
            archiveVO.setArchiveMonthVOS(archiveMonthVOS);
            archiveVOS.add(archiveVO);
        }
        return ResultBodyUtil.success(archiveVOS);
    }

    @Override
    public ResultBody countBlogNumberInFavorites(Long favoriteId) {
        Favorites allBlogFavoriteId = favoritesMapper.findAllBlogFavoriteId(favoriteId);
        List<BlogInfo> blogInfos = allBlogFavoriteId.getBlogInfos();
        int blogInfoNum = blogInfos.size();
        return ResultBodyUtil.success(blogInfoNum);
    }

    @Override
    public ResultBody countForBlogManage(Long userId) {
        List<BlogInfo> blogInfos = blogInfoMapper.findAllBlogByUserId(userId);
        long allNumber = blogInfos.size();
        long draftNumber = blogInfos.stream()
                .filter(blogInfo -> BlogStatusConstant.BLOG_DRAFT.equals(blogInfo.getBlogStatus()))
                .count();
        long publicNumber = blogInfos.stream()
                .filter(blogInfo -> BlogStatusConstant.BLOG_PUBLIC.equals(blogInfo.getBlogStatus()))
                .count();
        long privateNumber = blogInfos.stream()
                .filter(blogInfo -> BlogStatusConstant.BLOG_PRIVATE.equals(blogInfo.getBlogStatus()))
                .count();
        long auditNumber = blogInfos.stream()
                .filter(blogInfo -> BlogStatusConstant.BLOG_AUDIT.equals(blogInfo.getBlogStatus()))
                .count();
        long recycleNumber = blogInfos.stream()
                .filter(blogInfo -> BlogStatusConstant.BLOG_RECYCLE_BIN.equals(blogInfo.getBlogStatus()))
                .count();
        Map<String, Object> map = new ConcurrentHashMap<>(16);
        map.put("allNumber", allNumber);
        map.put("draftNumber", draftNumber);
        map.put("publicNumber", publicNumber);
        map.put("privateNumber", privateNumber);
        map.put("auditNumber", auditNumber);
        map.put("recycleNumber", recycleNumber);
        return ResultBodyUtil.success(map);
    }

    @Override
    public ResultBody countForOneBlog(Long blogId) {
        BlogInfo blogInfo = blogInfoMapper.findBlogInfoAndTagsByBlogInfoId(blogId);
        Integer blogPVNumber = blogInfo.getPageViewNum();
        Integer likeNumber = blogInfo.getLikeNum();
        Integer favoriteNumber = blogInfo.getFavorites().size();
        Map<String, Object> map = new ConcurrentHashMap<>(16);
        map.put("blogPVNumber", blogPVNumber);
        map.put("likeNumber", likeNumber);
        map.put("favoriteNumber", favoriteNumber);
        return ResultBodyUtil.success(map);
    }

    public List<BlogInfo> getBlogInfos() {
        // 尝试从redis中读取数据
        List<BlogInfo> blogInfos = redisRepository.getObject("blogInfoDetails");
        if (null == blogInfos) {
            blogInfos = blogInfoMapper.findAllBlogDetails();
            redisRepository.setObject("blogInfoDetails", blogInfos);
            System.out.println("====== 从数据库里面获取值 ======");
            return blogInfos;
        }
        return blogInfos;
    }

    /**
     * 1. 首先使用set的带过期时间的命令去获取锁，这里是 set key value expire time;就是设置值的同时并为其设置过期时间；
     * 这样保证了原子性；而将值设置成一个唯一的uuid是为了后面删除锁时，不会去删除其他线程的锁；比如A线程拿到锁，然后过期时间时30s，
     * 但是这个A线程的业务执行时间超过了30s；如果这个时候在去释放锁，那就是释放新线程B获得的锁，所以在后面会去以这个值去判断；
     * 2. 如果是获取失败那么就先睡眠一段时间（防止一直重复调用），然后自旋去等待；
     * 3. 获取锁的那个线程，释放的时候，需要先去获取值，然后在删除，这两步其实不是原子性的，所以需要通过Lua脚本来保证其原子运行
     *
     * @return
     */
    @Override
    public ResultBody findAllBlogDetailsByRedisLock() {

        // 生成唯一的一个值
        String uuidLock = UUID.randomUUID().toString();
        // 设置一个锁，也既在redis设置一个为空才能插入的kv，并设置过期时间
        Boolean blogLock = redisTemplate.opsForValue().setIfAbsent("blogLock", uuidLock, 300, TimeUnit.SECONDS);
        if (blogLock) {
            System.out.println("=== 获取分布式锁成功 ===");
            List<BlogInfo> blogInfos;
            try {
                blogInfos = getBlogInfos();
            } finally {
                // 执行redis 原子删除脚本，在该线程执行完之后，自动删除锁
                String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
                redisTemplate.execute(new DefaultRedisScript<Long>(script, Long.class), Arrays.asList("blogLock"), uuidLock);
            }
            return ResultBodyUtil.success(blogInfos);
        } else {
            System.out.println("=== 分布式锁获取失败 ===");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 调用自己，让失败的线程一直尝试抢占锁===相当于是自旋锁
            return findAllBlogDetailsByRedisLock();
        }
    }

    @Override
    public ResultBody findAllBlogDetailsByRedisson() {
        // 锁应该细粒度化，具体的缓存存的就是具体的对应对象
        RLock rLock = redissonClient.getLock("findAllBlogDetailsByRedisson-lock");
        rLock.lock();
        List<BlogInfo> blogInfos;
        try {
            blogInfos = getBlogInfos();
        } finally {
            rLock.unlock();
        }
        return ResultBodyUtil.success(blogInfos);
    }
}

