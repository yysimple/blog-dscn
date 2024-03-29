package com.jxkj.managecenter.sync;

import com.jxkj.common.constant.CanalConsist;
import com.jxkj.managecenter.repository.RedisRepository;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
/*@Component
@Order(1)
implements ApplicationRunner
*/
public class BlogInfoSync {

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    public void run(ApplicationArguments args) throws Exception {
        getCanalConn();
    }

    public void getCanalConn() {
        System.out.println(LocalDateTime.now());
        Set<String> keys = redisRepository.getKeys("blogInfoDetails");
        if (keys.size() <= 0) {
            List<BlogInfo> blogInfos = blogInfoMapper.findAllBlogDetails();
            redisRepository.setObject("blogInfoDetails", blogInfos);
        }
        // 创建链接
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(CanalConsist.CANAL_HOST,
                CanalConsist.CANAL_PORT), CanalConsist.CANAL_DESTINATION_BLOG, CanalConsist.CANAL_BLOG_USERNAME, CanalConsist.CANAL_BLOG_PASSWORD);
        int batchSize = 1000;
        try {
            connector.connect();
            connector.subscribe(".*\\..*");
            connector.rollback();
            while (true) {
                // 获取指定数量的数据
                Message message = connector.getWithoutAck(batchSize);
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    List<CanalEntry.Entry> entrys = message.getEntries();
                    for (CanalEntry.Entry entry : entrys) {
                        if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                            continue;
                        }

                        CanalEntry.RowChange rowChage = null;
                        try {
                            rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                        } catch (Exception e) {
                            throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                                    e);
                        }

                        CanalEntry.EventType eventType = rowChage.getEventType();
                        String eventTypeStr = eventType.toString();
                        boolean flag = ("INSERT".equals(eventTypeStr) ||
                                "CREATE".equals(eventTypeStr) || "UPDATE".equals(eventTypeStr) || "DELETE".equals(eventTypeStr));
                        boolean tableFlag = ("t_blog_info".equals(entry.getHeader().getTableName()) ||
                                "t_blog_info_category".equals(eventTypeStr) ||
                                "t_blog_info_tag".equals(eventTypeStr) ||
                                "t_blog_info_type".equals(eventTypeStr) ||
                                "t_blog_like_user".equals(eventTypeStr) ||
                                "t_blog_info_favorites".equals(eventTypeStr)
                        );
                        System.out.println(flag);
                        if (tableFlag && flag) {
                            redisRepository.del("blogInfoDetails");
                            List<BlogInfo> blogInfos = blogInfoMapper.findAllBlogDetails();
                           /* BlogInfoListForm blogInfoListForm = new BlogInfoListForm();
                            blogInfoListForm.setBlogInfos(blogInfos01);*/
                            redisRepository.setObject("blogInfoDetails", blogInfos);
                        }
                    }
                }
                connector.ack(batchId); // 提交确认
                // connector.rollback(batchId); // 处理失败, 回滚数据
            }
        } finally {
            connector.disconnect();
        }
    }
}
