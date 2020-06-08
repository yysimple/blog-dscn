package com.jxkj.blogresource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.blogresource.entity.ResourceType;
import com.jxkj.blogresource.mapper.ResourceTypeMapper;
import com.jxkj.blogresource.service.IResourceTypeService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-31
 */
@Service
public class ResourceTypeServiceImpl extends ServiceImpl<ResourceTypeMapper, ResourceType> implements IResourceTypeService {

    @Autowired
    private ResourceTypeMapper resourceTypeMapper;

    @Autowired
    private IResourceTypeService iResourceTypeService;

    @Override
    public ResultBody saveOrUpdateResourceType(ResourceType resourceType) {
        List<ResourceType> resourceTypes = resourceTypeMapper.selectList(null);
        boolean exist = resourceTypes.stream().anyMatch(u -> u.getTypeName().equals(resourceType.getTypeName()));
        if (!exist) {
            iResourceTypeService.saveOrUpdate(resourceType);
            return ResultBodyUtil.success();
        } else {
            return ResultBodyUtil.error(ResultTypeEnum.ALREADY_EXIST.getCode(), ResultTypeEnum.ALREADY_EXIST.getMsg());
        }

    }

    @Override
    public ResultBody listTypeWithTree() {
        List<ResourceType> entities = resourceTypeMapper.selectList(null);
        List<ResourceType> levelMenus = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentId() == 0
        ).map(menu -> {
            menu.setChildren(getChildren(menu, entities));
            return menu;
        }).collect(Collectors.toList());
        return ResultBodyUtil.success(levelMenus);
    }

    private List<ResourceType> getChildren(ResourceType root, List<ResourceType> all) {
        List<ResourceType> children = all.stream().filter(categoryEntity ->
                categoryEntity.getParentId().equals(root.getId())).map(categoryEntity -> {
                    // 找到子菜单
                    categoryEntity.setChildren(getChildren(categoryEntity, all));
                    return categoryEntity;
                }).collect(Collectors.toList());
        return children;
    }
}
