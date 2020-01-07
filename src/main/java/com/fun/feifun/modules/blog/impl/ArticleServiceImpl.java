package com.fun.feifun.modules.blog.impl;

import com.fun.feifun.modules.blog.model.Article;
import com.fun.feifun.modules.blog.dao.ArticleMapper;
import com.fun.feifun.modules.blog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客_文章 服务实现类
 * </p>
 *
 * @author wkf
 * @since 2020-01-07
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
