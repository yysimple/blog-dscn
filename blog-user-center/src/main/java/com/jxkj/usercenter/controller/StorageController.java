package com.jxkj.usercenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.usercenter.service.IStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 测试分布式锁的库存表 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@RestController
public class StorageController {
    @Resource
    private IStorageService storageService;

    @PostMapping("/storage/decrease")
    public ResultBody decrease(Long productId, Integer count){
        storageService.decrease(productId, count);
        return ResultBodyUtil.success("扣除库存成功!");
    }}
