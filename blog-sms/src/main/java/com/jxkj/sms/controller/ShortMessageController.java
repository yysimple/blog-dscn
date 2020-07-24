package com.jxkj.sms.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.sms.form.CheckCodeForm;
import com.jxkj.sms.service.ShortMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述：
 * 修改日志：
 * - 2020/1/7, 7:52 创建
 *
 * @author 吴呈兴
 * @version 1.0.0.RELEASE
 */
@RestController
@RequestMapping("/sms")
@Slf4j
@Api(tags = "发送短信的接口")
public class ShortMessageController {

    private final ShortMessageService shortMessageService;

    public ShortMessageController(ShortMessageService shortMessageService) {
        this.shortMessageService = shortMessageService;
    }

    @ApiOperation(value = "DSCN用户注册")
    @PostMapping("/sendToDSCNRegister")
    public ResultBody sendToDSCNRegister(@RequestParam("phone") String phone) {
        return shortMessageService.sendToDSCNRegister(phone);
    }

    @ApiOperation(value = "校验验证码")
    @PostMapping("/checkCode")
    public ResultBody checkCode(@RequestBody CheckCodeForm checkCodeForm){
        return shortMessageService.checkCode(checkCodeForm);
    }

    @ApiOperation(value = "测试DSCN用户注册")
    @PostMapping("/sendToDSCNRegisterTest")
    public ResultBody sendToDSCNRegisterTest(@RequestParam("phone") String phone) {
        return shortMessageService.sendToDSCNRegisterTest(phone);
    }

    @ApiOperation(value = "测试校验验证码")
    @PostMapping("/checkCodeTest")
    public ResultBody checkCodeTest(@RequestBody CheckCodeForm checkCodeForm){
        return shortMessageService.checkCodeTest(checkCodeForm);
    }
}
