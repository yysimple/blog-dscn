package com.jxkj.sms.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.sms.form.CheckCodeForm;
import com.jxkj.sms.service.ShortMessageService;
import com.jxkj.sms.util.AliyunUtil;
import com.jxkj.sms.util.RandomCodeUtil;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：
 * 修改日志：
 * - 2020/1/12, 3:48 吴呈兴 创建
 *
 * @author 吴呈兴
 * @version 1.0.0.RELEASE
 */
@Service
public class ShortMessageServiceImpl implements ShortMessageService {

    /**
     * 返回值为ok的状态
     */
    private final String CODE_STATUS = "OK";

    /**
     * redis缓存中key的前缀
     */
    private final String CODE_PREFIX = "sms:code:";

    /**
     * code过期时间
     */
    private final Long EXPIRATION = 120000L;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResultBody sendToDSCNRegister(String phone) {
        String codeKey = CODE_PREFIX + phone;
        String redisExistCode = (String) redisTemplate.opsForValue().get(codeKey);
        if (redisExistCode != null) {
            String[] codeAndTime = redisExistCode.split("_");
            long createTime = Long.getLong(codeAndTime[1]);
            long nowTime = System.currentTimeMillis();
            if (nowTime - createTime < EXPIRATION) {
                return ResultBodyUtil.error(ResultTypeEnum.CODE_NOT_EXPIRATION.getCode(), ResultTypeEnum.CODE_NOT_EXPIRATION.getMsg());
            } else {
                String code = RandomCodeUtil.getSixCode();
                String codeValue = code + "_" + System.currentTimeMillis();
                SendSmsResponse sendSmsResponse = AliyunUtil.sendSmsToDSCNRegister(phone, code);
                if (sendSmsResponse.getCode() != null && CODE_STATUS.equals(sendSmsResponse.getCode())) {
                    redisTemplate.opsForValue().set(codeKey, codeValue, 120, TimeUnit.SECONDS);
                    return ResultBodyUtil.success(code);
                }
                return ResultBodyUtil.error(ResultTypeEnum.PHONE_INFO_EXCEPTION.getCode(), ResultTypeEnum.PHONE_INFO_EXCEPTION.getMsg());
            }
        }
        String code = RandomCodeUtil.getSixCode();
        String codeValue = code + "_" + System.currentTimeMillis();
        SendSmsResponse sendSmsResponse = AliyunUtil.sendSmsToDSCNRegister(phone, code);
        if (sendSmsResponse.getCode() != null && CODE_STATUS.equals(sendSmsResponse.getCode())) {
            redisTemplate.opsForValue().set(codeKey, codeValue, 120, TimeUnit.SECONDS);
            return ResultBodyUtil.success(code);
        }
        return ResultBodyUtil.error(ResultTypeEnum.PHONE_INFO_EXCEPTION.getCode(), ResultTypeEnum.PHONE_INFO_EXCEPTION.getMsg());
    }

    @Override
    public ResultBody checkCode(CheckCodeForm checkCodeForm) {
        String code = checkCodeForm.getCode();
        String phone = checkCodeForm.getPhone();
        String redisCodeValue = (String) redisTemplate.opsForValue().get(CODE_PREFIX + phone);
        String[] codeAndTime = redisCodeValue.split("_");
        long createTime = Long.getLong(codeAndTime[1]);
        long nowTime = System.currentTimeMillis();
        if (nowTime - createTime > EXPIRATION) {
            return ResultBodyUtil.error(ResultTypeEnum.CODE_FAILURE.getCode(), ResultTypeEnum.CODE_FAILURE.getMsg());
        }
        if (!codeAndTime[0].equals(code)) {
            return ResultBodyUtil.error(ResultTypeEnum.CODE_NOT_TRUE.getCode(), ResultTypeEnum.CODE_NOT_TRUE.getMsg());
        }
        return ResultBodyUtil.success(true);
    }

    @Override
    public ResultBody sendToDSCNRegisterTest(String phone) {
        String codeKey = CODE_PREFIX + phone;
        String redisExistCode = (String) redisTemplate.opsForValue().get(codeKey);
        if (redisExistCode != null) {
            String[] codeAndTime = redisExistCode.split("_");
            long createTime = new Long(codeAndTime[1]);
            long nowTime = System.currentTimeMillis();
            if (nowTime - createTime < EXPIRATION) {
                return ResultBodyUtil.error(ResultTypeEnum.CODE_NOT_EXPIRATION.getCode(), ResultTypeEnum.CODE_NOT_EXPIRATION.getMsg());
            } else {
                String code = RandomCodeUtil.getSixCode();
                String codeValue = code + "_" + System.currentTimeMillis();
                redisTemplate.opsForValue().set(codeKey, codeValue, 120, TimeUnit.SECONDS);
                return ResultBodyUtil.success(code);
            }
        }
        String code = RandomCodeUtil.getSixCode();
        String codeValue = code + "_" + System.currentTimeMillis();
        redisTemplate.opsForValue().set(codeKey, codeValue, 120, TimeUnit.SECONDS);
        return ResultBodyUtil.success(code);
    }

    @Override
    public ResultBody checkCodeTest(CheckCodeForm checkCodeForm) {
        String code = checkCodeForm.getCode();
        String phone = checkCodeForm.getPhone();
        String redisCodeValue = (String) redisTemplate.opsForValue().get(CODE_PREFIX + phone);
        String[] codeAndTime = redisCodeValue.split("_");
        long createTime = new Long(codeAndTime[1]);
        long nowTime = System.currentTimeMillis();
        if (nowTime - createTime > EXPIRATION) {
            return ResultBodyUtil.error(ResultTypeEnum.CODE_FAILURE.getCode(), ResultTypeEnum.CODE_FAILURE.getMsg());
        }
        if (!codeAndTime[0].equals(code)) {
            return ResultBodyUtil.error(ResultTypeEnum.CODE_NOT_TRUE.getCode(), ResultTypeEnum.CODE_NOT_TRUE.getMsg());
        }
        return ResultBodyUtil.success(true);
    }
}
