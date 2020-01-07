package com.fun.feifun.modules.blog.impl;

import com.fun.feifun.modules.blog.model.Category;
import com.fun.feifun.modules.blog.dao.CategoryMapper;
import com.fun.feifun.modules.blog.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wkf
 * @since 2020-01-07
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
