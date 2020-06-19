package com.jxkj.managecenter.form;

import com.jxkj.managecenter.entity.BlogInfo;
import lombok.Data;

import java.util.List;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
public class BlogInfoListForm {
    private List<BlogInfo> blogInfos;
}
