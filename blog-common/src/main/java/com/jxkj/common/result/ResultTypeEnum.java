package com.jxkj.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 功能描述：返回失败信息封装
 *
 * @author 吴呈兴
 * @version 1.0.0.RELEASE
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultTypeEnum {

    /**
     *
     */
    WX_BINDING_FAILED(101, "微信绑定失败"),
    CHANGE_WX_BIND_PENDING(102, "已提交换绑申请，请耐心等待"),
    USER_NOT_BINDING_WX(103, "该用户还未绑定微信号"),
    WX_LOGIN_UNAVAILABLE(104, "该账号可能正在审批，请等待或联系管理员"),
    WX_OF_REPAIR_UNAVAILABLE(105, "该微信账号所属的维修企业还未通过审核"),
    WX_ALREADY_EXIST(106, "该微信号已经绑定"),
    WX_NO_REGISTER(107, "请先注册！"),

    ORDER_NOT_EXIST(501, "订单不存在，或者已被回收，请刷新"),

    PARAM_NOT_EMPTY(601, "参数不能为空,请填写"),
    PARAM_EXCEPTION(602, "参数传入异常，请输入正确的参数"),


    USER_DISABLED(701, "用户被禁用"),
    USER_NOT_EXIST(702, "用户不存在"),
    USER_ALREADY_EXIST(703, "用户已经存在，请重新输入"),
    USERNAME_PASSWORD_FAIL(704, "请检查用户名和密码是否正确"),
    OLD_PASSWORD_ERROR(705, "旧密码不正确，请重新输入"),
    PASSWORD_NOT_TRUE(706, "密码不正确，请确认密码"),
    USER_NOT_USE(707, "账号正在审批，请耐心等待"),
    RECYCLER_ALREADY_LEAVE(708, "该回员已离职"),
    REGISTER_NOT_PASS(709, "您的注册信息被驳回，请重新注册"),

    PHONE_ALREADY_REGISTER(801, "手机号已注册，请选择其他手机号或直接登录"),
    PHONE_NOT_REGISTER(802, "该手机号用户不存在，请检查手机号和密码"),
    PHONE_INFO_EXCEPTION(803, "手机信息异常，请仔细核对"),
    PHONE_VERIFY_FAIL(804, "手机校验失败，请检查验证码"),

    TOKEN_NOT_EXIST(901, "token不存在或者已经失效"),
    INFO_NOT_EXIST(902, "该条资讯不存在，请刷新小程序"),
    COMPANY_NAME_ALREADY_EXIST(903, "该企业名称已被注册，请选择其他的名称再次进行注册"),
    DATA_ALREADY_EXIST(904, "该数据在数据库已存在")

    ;
    private Integer code;

    private String msg;


}
