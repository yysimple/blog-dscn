package com.jxkj.managecenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.entity.BlogTag;
import com.jxkj.managecenter.feign.UserInfoFeignService;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.mapper.BlogTagMapper;
import com.jxkj.managecenter.service.BlogIndexService;
import com.jxkj.managecenter.vo.BlogIndexVO;
import com.jxkj.managecenter.vo.BlogInfoIndexVO;
import com.jxkj.managecenter.vo.BlogInfoVO;
import com.jxkj.managecenter.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2020-07-23 10:16
 **/
@Service
@Slf4j
public class BlogIndexServiceImpl implements BlogIndexService {

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private UserInfoFeignService userInfoFeignService;

    @Autowired
    private ThreadPoolExecutor executor;

    @Override
    public ResultBody getIndexDetails(Long userId, Long blogTagId) {
        Long start = System.currentTimeMillis();
        // 1. 建模，返回一个带有首页需要的所有模型数据
        BlogIndexVO blogIndexVO = new BlogIndexVO();

        // 2. 获取首页需要加载的所有的博客标签
        List<BlogTag> blogTags = blogTagMapper.selectList(null);
        blogIndexVO.setBlogTags(blogTags);

        // 3. 获取首页需要的用户信息
        ResultBody resultBody = userInfoFeignService.selectUserInfoById(userId);
        String str = JSON.toJSONString(resultBody.getData());
        UserVO userVO = JSON.parseObject(str, UserVO.class);
        blogIndexVO.setUserVO(userVO);

        // 4. 获取对应标签下的所有博客
        List<BlogInfoIndexVO> blogInfoIndexVOList = new ArrayList<>();
        List<BlogInfo> blogInfos = blogInfoMapper.listBlogInfoByBlogTagId(blogTagId);
        for (BlogInfo blogInfo : blogInfos) {
            BlogInfoIndexVO blogInfoIndexVO = new BlogInfoIndexVO();
            BlogInfoVO blogInfoVO = new BlogInfoVO();
            BeanUtils.copyProperties(blogInfo, blogInfoVO);
            blogInfoIndexVO.setBlogInfoVO(blogInfoVO);

            Long id = blogInfo.getTUserId();
            ResultBody resultBody1 = userInfoFeignService.selectUserInfoById(id);
            String str1 = JSON.toJSONString(resultBody1.getData());
            UserVO userVO1 = JSON.parseObject(str1, UserVO.class);
            blogInfoIndexVO.setUserVO(userVO1);

            blogInfoIndexVOList.add(blogInfoIndexVO);
        }
        blogIndexVO.setBlogInfoIndexVOList(blogInfoIndexVOList);
        Long end = System.currentTimeMillis();
        System.out.println("正常单接口===执行时间：" + (end - start));
        return ResultBodyUtil.success(blogIndexVO);
    }

    @Override
    public ResultBody getIndexDetailsByCompletable(Long userId, Long blogTagId) {
        // Long start = System.currentTimeMillis();
        // 1. 建模，返回一个带有首页需要的所有模型数据
        BlogIndexVO blogIndexVO = new BlogIndexVO();

        // 2. 获取首页需要加载的所有的博客标签
        CompletableFuture<Void> blogTagsFuture = CompletableFuture.runAsync(() -> {
            List<BlogTag> blogTags = blogTagMapper.selectList(null);
            blogIndexVO.setBlogTags(blogTags);
        }, executor);

        // 3. 获取首页需要的用户信息
        CompletableFuture<Void> userVOFuture = CompletableFuture.runAsync(() -> {
            ResultBody resultBody = userInfoFeignService.selectUserInfoById(userId);
            String str = JSON.toJSONString(resultBody.getData());
            UserVO userVO = JSON.parseObject(str, UserVO.class);
            blogIndexVO.setUserVO(userVO);
        }, executor);

        // 4. 获取所有博客详情
        CompletableFuture<List<BlogInfo>> listBlogInfoFuture = CompletableFuture.supplyAsync(() -> {
            List<BlogInfo> blogInfos = blogInfoMapper.listBlogInfoByBlogTagId(blogTagId);
            return blogInfos;
        }, executor);

        // 5. 获取每篇博客对应的用户信息
        CompletableFuture<Void> blogInfoIndexFuture = listBlogInfoFuture.thenAcceptAsync(blogInfos -> {
            List<BlogInfoIndexVO> blogInfoIndexVOList = new ArrayList<>();
            for (BlogInfo blogInfo : blogInfos) {
                BlogInfoIndexVO blogInfoIndexVO = new BlogInfoIndexVO();
                BlogInfoVO blogInfoVO = new BlogInfoVO();
                BeanUtils.copyProperties(blogInfo, blogInfoVO);
                blogInfoIndexVO.setBlogInfoVO(blogInfoVO);

                Long id = blogInfo.getTUserId();
                ResultBody resultBody1 = userInfoFeignService.selectUserInfoById(id);
                String str1 = JSON.toJSONString(resultBody1.getData());
                UserVO userVO1 = JSON.parseObject(str1, UserVO.class);
                blogInfoIndexVO.setUserVO(userVO1);
                blogInfoIndexVOList.add(blogInfoIndexVO);
            }
            blogIndexVO.setBlogInfoIndexVOList(blogInfoIndexVOList);
        }, executor);

        try {
            CompletableFuture.allOf(blogTagsFuture, userVOFuture, listBlogInfoFuture, blogInfoIndexFuture).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // Long end = System.currentTimeMillis();
        // System.out.println("异步编排===执行时间：" + (end - start));
        return ResultBodyUtil.success(blogIndexVO);
    }
}
