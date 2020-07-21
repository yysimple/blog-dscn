package com.jxkj.usercenter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Component
public class RedisRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 判断key是否存在
     *
     * @param key
     * @return 结果
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 实现命令：expire 设置过期时间，单位秒
     *
     * @param key
     * @return
     */
    public void expire(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     * @return 结果 缓存的对象
     */
    public <T> ValueOperations<String, T> setObject(String key, T value, Long time) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value, time, TimeUnit.MINUTES);
        return operation;
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     * @return 结果 缓存的对象
     */
    public <T> ValueOperations<String, T> setObjectExpiredSeconds(String key, T value, Long time) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value, time, TimeUnit.SECONDS);
        return operation;
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     * @return 结果 缓存的对象
     */
    public <T> ValueOperations<String, T> setObject(String key, T value) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value);
        this.setDefaultExpire(key);
        return operation;
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 结果 缓存键值对应的数据
     */
    public <T> T getObject(String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 结果 缓存的对象
     */
    public <T> ListOperations<String, T> setList(String key, List<T> dataList) {
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                listOperation.rightPush(key, dataList.get(i));
            }
        }
        this.setDefaultExpire(key);
        return listOperation;
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 结果 缓存的对象
     */
    public <T> ListOperations<String, T> setList(String key, List<T> dataList, Long time) {
        ListOperations listOperation = redisTemplate.opsForList();

        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                listOperation.rightPush(key, dataList.get(i));
            }
        }
        this.setDefaultExpire(key);
        return listOperation;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 结果 缓存键值对应的数据
     */
    public <T> List<T> getList(String key) {
        List<T> dataList = new ArrayList<>();
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        for (int i = 0; i < size; i++) {
            dataList.add((T) listOperation.leftPop(key));
        }
        return dataList;
    }

    /**
     * 缓存Set
     *
     * @param key     缓存键值
     * @param dataSet 缓存的数据
     * @return 结果 缓存数据的对象
     */
    public <T> BoundSetOperations<String, T> setSet(String key, Set<T> dataSet) {
        BoundSetOperations setOperation = redisTemplate.boundSetOps(key);
        for (T t : dataSet) {
            setOperation.add(t);
        }
        this.setDefaultExpire(key);
        return setOperation;
    }

    /**
     * 获得缓存的set
     *
     * @param key 缓存键值
     * @return 结果 缓存数据的对象
     */
    public Set getSet(String key) {
        Set dataSet = new HashSet();
        BoundSetOperations operation = redisTemplate.boundSetOps(key);

        Long size = operation.size();
        for (int i = 0; i < size; i++) {
            dataSet.add(operation.pop());
        }
        return dataSet;
    }

    /**
     * 缓存Map
     *
     * @param key     缓存键值
     * @param dataMap 缓存的数据
     * @return 结果
     */
    public <T> HashOperations setMap(String key, Map<String, T> dataMap) {

        HashOperations hashOperations = redisTemplate.opsForHash();
        if (null != dataMap) {
            for (Map.Entry<String, T> entry : dataMap.entrySet()) {
                hashOperations.put(key, entry.getKey(), entry.getValue());
            }
        }
        this.setDefaultExpire(key);
        return hashOperations;
    }

    /**
     * 获得缓存的Map
     *
     * @param key 缓存键值
     * @return 结果
     */
    public <T> Map<String, T> getMap(String key) {
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        return map;
    }

    /**
     * 实现命令：DEL key，删除一个key
     *
     * @param key 缓存的键值
     */
    public void delHash(String hash, String key) {
        redisTemplate.opsForHash().delete(hash, key);
    }

    /**
     * 实现命令：DEL key，删除一个key
     *
     * @param key 缓存的键值
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 设置默认失效时间
     *
     * @param key
     */
    public void setDefaultExpire(String key) {
        this.redisTemplate.expire(key, 3600 * 30L, TimeUnit.SECONDS);
    }

    /**
     * 发布消息
     *
     * @param channel
     * @param object
     */
    public void pub(String channel, Object object) {
        redisTemplate.convertAndSend(channel, object);

    }

    public RedisSerializer<?> getValueSerializer() {
        return redisTemplate.getValueSerializer();
    }

    public Set<String> getKeys(String pattern) {
        return redisTemplate.keys(pattern);
    }
}
