package com.jxkj.managecenter.vo;

import com.jxkj.managecenter.entity.BlogInfo;
import lombok.Data;

/**
 * 功能描述:
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Data
public class BlogUserInfoVO {

    private BlogInfo blogInfo;

    private UserVO user;

}
