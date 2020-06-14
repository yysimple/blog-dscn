package com.jxkj.usercenter.form;

import lombok.Data;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
public class BlogInfoAndTagForm {

    private BlogInfoForm blogInfoForm;

    private Long[] tagIds;

    private String[] tagNames;
}
