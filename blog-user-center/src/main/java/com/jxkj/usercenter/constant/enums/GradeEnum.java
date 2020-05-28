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
public enum GradeEnum {

    GRADE_ONE(1,0),
    GRADE_TWO(2,100),
    GRADE_THREE(3,500),
    GRADE_FOUR(4,1000),
    GRADE_FIVE(5,2000),
    GRADE_SIX(6,5000),
    GRADE_SEVEN(7,10000),
    GRADE_EIGHT(8,30000),
    GRADE_NINE(9,50000),
    GRADE_TEN(10,100000),
    GRADE_ELEVEN(11,200000),
    GRADE_TWELVE(12,300000),
    GRADE_THIRTEEN(13,500000),
    GRADE_FOURTEEN(14,800000),
    GRADE_FIFTEEN(15,1000000),
    ;

    private Integer geade;

    private Integer score;
}
