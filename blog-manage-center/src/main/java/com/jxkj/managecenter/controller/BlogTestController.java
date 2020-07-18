package com.jxkj.managecenter.controller;

import cn.hutool.core.text.replacer.StrReplacer;
import com.jxkj.common.result.ResultBody;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: blog-dscn
 * @description: 博客测试接口
 * @author: WuChengXing
 * @create: 2020-07-18 22:32
 **/
@RestController
public class BlogTestController {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        // 1. 获取锁,这里redisson会自动帮你续期，也会帮你解决死锁的问题，为锁加上30s的默认过期时间，续期是在你业务逻辑没完成的时候才会帮你续期
        RLock rLock = redissonClient.getLock("r-lock");
        // 2. 给业务逻辑代码加锁
        // rLock.lock();
        /**
         * 两种加锁的方法区别：
         * 1. 上面那种是默认的时间，为看门狗时间 == 》 this.internalLockLeaseTime = commandExecutor.getConnectionManager().getCfg().getLockWatchdogTimeout();
         * 如果改时间过期，redisson底层会自动帮我们续期，不需要我们去做操作，但是去续期是需要消耗时间和性能的
         * 2. 自己设置时间，但是会造成 业务还没执行完时，锁已经释放的情况。
         *
         */
        rLock.lock(10, TimeUnit.SECONDS);
        try {
            System.out.println("获取锁成功 ==== " + Thread.currentThread().getName() + "===" + Thread.currentThread().getId());
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3. 业务逻辑执行完成，释放锁
            rLock.unlock();
        }
        return "hello";
    }

    @GetMapping("/write")
    public String write() {
        RReadWriteLock rReadWriteLock = redissonClient.getReadWriteLock("RW-lock");
        RLock rLock = rReadWriteLock.writeLock();
        try {
            rLock.lock();
            System.out.println(Thread.currentThread().getId() + " ===  正在进行写操作 === ");
            String s = UUID.randomUUID().toString();
            Thread.sleep(15000);
            redisTemplate.opsForValue().set("wirteLock", s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
            System.out.println("=== 写锁释放 ===");
        }
        return "写成功";
    }

    @GetMapping("/read")
    public String read() {
        RReadWriteLock rReadWriteLock = redissonClient.getReadWriteLock("RW-lock");
        RLock rLock = rReadWriteLock.readLock();
        try {
            rLock.lock();
            System.out.println(Thread.currentThread().getId() + " === 读锁正在起作用 ===");
            String s = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set("readLock", s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
            System.out.println("=== 读锁释放 ===");
        }
        return "读成功";
    }

    @GetMapping("/lockDoor")
    public String lockDoor() {
        RCountDownLatch rCountDownLatch = redissonClient.getCountDownLatch("door");
        System.out.println("==== 开始等待学生离校 ====");
        rCountDownLatch.trySetCount(5);
        try {
            rCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关门");
        return "关门";
    }

    @GetMapping("/goHome/{id}")
    public String goHome(@PathVariable("id") Long id) {
        RCountDownLatch rCountDownLatch = redissonClient.getCountDownLatch("door");
        System.out.println(id + "班 ==== 开始离校 ====");
        rCountDownLatch.countDown();
        return "回家";
    }
}
