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
    ALREADY_EXIST(101,"收藏夹已存在"),

    FILE_TOO_LARGE(501, "文件过大, 请从新上传（小于100MB）"),

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

    ;
    private Integer code;

    private String msg;


}
