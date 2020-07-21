package com.jxkj.usercenter.sync;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;
import com.jxkj.common.constant.CanalConsist;
import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.entity.UserInfo;
import com.jxkj.usercenter.mapper.UserMapper;
import com.jxkj.usercenter.repository.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @program: blog-dscn
 * @description: 用户模块数据同步端
 * @author: WuChengXing
 * @create: 2020-07-21 19:36
 **/
@Component
@Slf4j
public class UserCanalClient {

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private UserMapper userMapper;

    /**
     * canal入库方法
     */
    public void run() {

        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(CanalConsist.CANAL_HOST,
                CanalConsist.CANAL_PORT), CanalConsist.CANAL_DESTINATION_USER, CanalConsist.CANAL_USER_USERNAME, CanalConsist.CANAL_USER_PASSWORD);
        int batchSize = 1000;
        try {
            connector.connect();
            connector.subscribe(".*\\..*");
            connector.rollback();
            try {
                while (true) {
                    //尝试从master那边拉去数据batchSize条记录，有多少取多少
                    Message message = connector.getWithoutAck(batchSize);
                    long batchId = message.getId();
                    int size = message.getEntries().size();
                    if (batchId == -1 || size == 0) {
                        Thread.sleep(1000);
                    } else {
                        dataHandle(message.getEntries());
                    }
                    connector.ack(batchId);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        } finally {
            connector.disconnect();
        }
    }


    /**
     * 数据处理
     *
     * @param entrys
     */
    private void dataHandle(List<CanalEntry.Entry> entrys) throws InvalidProtocolBufferException {
        for (CanalEntry.Entry entry : entrys) {
            if (CanalEntry.EntryType.ROWDATA == entry.getEntryType()) {
                CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                CanalEntry.EventType eventType = rowChange.getEventType();
                if (eventType == CanalEntry.EventType.DELETE || eventType == CanalEntry.EventType.UPDATE || eventType == CanalEntry.EventType.INSERT) {
                    log.info("eventType: {}", eventType);
                    List<User> users = redisRepository.getObject("users");
                    if (users != null) {
                        redisRepository.del("users");
                        List<User> allUser = userMapper.selectList(null);
                        redisRepository.setObject("users", allUser);
                    } else {
                        List<User> allUser = userMapper.selectList(null);
                        redisRepository.setObject("users", allUser);
                    }
                }
            }
        }
    }
}
