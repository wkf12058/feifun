package com.fun.feifun.modules.blog.controller;
import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
import com.fun.feifun.modules.blog.service.IArticleService;
import com.fun.feifun.modules.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fun.feifun.base.result.Result;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;

import java.util.List;

/**
 * <p>
 * 博客_文章 前端控制器
 * </p>
 *
 * @author wkf
 * @since 2020-01-07
 */
@RestController
@Api(value = "/blog/article", tags = "博客_文章")
@Slf4j
@RequestMapping("/blog/article")
    public class ArticleController {


    @Autowired
    private IArticleService service;

    /**
     * 获取分页
     */
    @PostMapping("/page")
    @ApiOperation(value = "获取分页信息")
    public Result page(@RequestParam(name = "page", defaultValue = "1") int index,@RequestParam(name = "rows", defaultValue = "20") int size){
        Page page = new Page(index,size);
        service.page(page);
        return Result.success(page);
    }


    /**
     * 获取全部数据
     */
    @GetMapping("/all")
    @ApiOperation(value = "获取全部数据")
    public Result findAll(){
        List<Article> models = service.list();
        return Result.success(models);
    }


    /**
     * 根据ID查找数据
     */
    @GetMapping("/find")
    @ApiOperation(value = "查找")
    public Result find(@RequestParam("id") Long id){
        Article Article = service.getById(id);
        if(Article==null){
            return Result.err("尚未查询到此ID");
        }
        return Result.success(Article);
    }


    /**
     * 添加数据
     */
    @PostMapping(value = "/save")
    @ApiOperation(value = "添加或者保存")
    public Result save(@RequestBody Article Article){
        if(service.saveOrUpdate(Article)){
         return Result.success("数据添加成功！");
        }
        return Result.err("数据添加成功！");
    }



/**
 * 删除数据
 */
@PostMapping("/del")
@ApiOperation(value = "删除")
public Result deleteItems(@RequestParam("ids") List<Long> ids){
    if(service.removeByIds(ids)){
        return Result.success("数据删除成功！");
        }
        return Result.err("数据删除失败");
    }
}

