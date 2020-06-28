package com.jxkj.managecenter.form;

import lombok.Data;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
public class AllBlogByFuzzyForm {

    private Long userId;

    private Integer blogStatus;

    private String blogType;

    private String blogCategory;

    private String startTime;

    private String endTime;

    private String keyword;
}
