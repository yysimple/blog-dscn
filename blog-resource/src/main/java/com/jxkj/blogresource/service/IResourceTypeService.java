package com.jxkj.blogresource.service;

import com.jxkj.blogresource.entity.ResourceType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.common.result.ResultBody;

/**
 * 服务类
 *
 * @author GuJunBin
 * @since 2020-05-31
 */
public interface IResourceTypeService extends IService<ResourceType> {

    /**
     * 功能描述: 保存资源类型
     *
     * @author GuJunBin
     * @param resourceType
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody saveOrUpdateResourceType(ResourceType resourceType);

    /**
     * 功能描述: 查出所有分类以及子分类，以树形结构组装起来
     *
     * @author GuJunBin
     * @param
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody listTypeWithTree();
}
