package com.jxkj.usercenter.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ysq
 * @description
 * @date 2020/5/28
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum BlogPointsEnum {

    /**
     *
     */
    ORIGINAL("原创", 10),
    REPRINT("转载", 2),
    DELETE_ORIGINAL("删除原创", -10),
    DELETE_REPRINT("删除转载", -2),
    COLLECT("收藏", 2);

    private String description;
    private Integer score;
}
