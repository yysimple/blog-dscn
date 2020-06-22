package com.jxkj.managecenter.vo;

import com.jxkj.managecenter.entity.Favorites;
import lombok.Data;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
public class FavoritesBlogVO {

    private Favorites favorite;

    private Integer blogNum;
}
