package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogType;
import com.jxkj.managecenter.mapper.BlogTypeMapper;
import com.jxkj.managecenter.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 博客类型表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements IBlogTypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Override
    public ResultBody saveOrUpdateType(BlogType blogType) {
        QueryWrapper<BlogType> queryWrapper = new QueryWrapper<>();
        List<BlogType> blogTypes = blogTypeMapper.selectList(queryWrapper);
        boolean result = blogTypes.stream().anyMatch(u -> u.getType().equals(blogType.getType()));
        if (!result && blogType.getId() == null){
            return ResultBodyUtil.success(blogTypeMapper.insert(blogType));
        }else if (!result && blogType.getId() != null) {
            return ResultBodyUtil.success(blogTypeMapper.updateById(blogType));
        }else {
            return ResultBodyUtil.error(
                    ResultTypeEnum.ALREADY_EXIST.getCode(),
                    ResultTypeEnum.ALREADY_EXIST.getMsg());
        }
    }
}
