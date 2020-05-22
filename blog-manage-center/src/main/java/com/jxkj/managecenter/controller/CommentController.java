package com.jxkj.managecenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.Comment;
import com.jxkj.managecenter.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogCenter/comment")
@Api(tags = "博客留言模块 接口")
@Slf4j
public class CommentController {

    @Autowired
    private ICommentService iCommentService;

    private QueryWrapper<Comment> queryWrapper = Wrappers.query();
    IPage<Comment> page = new Page(1, 10);

    @ApiOperation(value = "分页查询当前博客所有评论")
    @GetMapping("/findComment")
    public ResultBody findComment(Long tBlogInfoId){
        queryWrapper.eq("t_blog_info_id",tBlogInfoId);
        IPage<Comment> commentIPage = iCommentService.page(this.page, queryWrapper);
        return ResultBodyUtil.success(commentIPage);
    }

    @ApiOperation(value = "提交留言")
    @PostMapping("/commitComment")
    public ResultBody commitComment(@RequestBody Comment comment){
        iCommentService.save(comment);
        return ResultBodyUtil.success();
    }
}
