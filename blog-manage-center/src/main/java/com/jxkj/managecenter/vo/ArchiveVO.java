package com.jxkj.managecenter.vo;

import lombok.Data;

import java.util.List;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
public class ArchiveVO {

    private String archiveYear;

    List<ArchiveMonthVO> archiveMonthVOS;
}
