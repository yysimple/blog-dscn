package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogInfoType;
import com.jxkj.managecenter.entity.BlogType;
import com.jxkj.managecenter.mapper.BlogInfoTypeMapper;
import com.jxkj.managecenter.mapper.BlogTypeMapper;
import com.jxkj.managecenter.service.IBlogTypeService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements IBlogTypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Autowired
    private BlogInfoTypeMapper blogInfoTypeMapper;

    @Autowired
    private IBlogTypeService iBlogTypeService;

    @Override
    public ResultBody saveOrUpdateType(BlogType blogType) {
        QueryWrapper<BlogType> queryWrapper = new QueryWrapper<>();
        List<BlogType> blogTypes = blogTypeMapper.selectList(queryWrapper);
        boolean exist = blogTypes.stream().anyMatch(u -> u.getType().equalsIgnoreCase(blogType.getType()));
        if (!exist ){
            return ResultBodyUtil.success(iBlogTypeService.saveOrUpdateType(blogType));
        }else {
            return ResultBodyUtil.error(
                    ResultTypeEnum.ALREADY_EXIST.getCode(),
                    ResultTypeEnum.ALREADY_EXIST.getMsg());
        }
    }

    @Override
    public ResultBody deleteById(Long id) {
        QueryWrapper<BlogInfoType> queryWrapper = new QueryWrapper<>();
        BlogInfoType blogInfoType = blogInfoTypeMapper.selectOne(queryWrapper.eq("t_blog_type_id", id));
        if (blogInfoType == null){
            blogTypeMapper.deleteById(id);
            return ResultBodyUtil.success();
        }else {
            return ResultBodyUtil.error(ResultTypeEnum.CAN_NOT_DELETE.getCode(), ResultTypeEnum.CAN_NOT_DELETE.getMsg());
        }

    }
}
