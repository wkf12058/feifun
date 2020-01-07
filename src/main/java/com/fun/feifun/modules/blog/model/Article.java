package com.fun.feifun.modules.blog.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fun.feifun.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客_文章
 * </p>
 *
 * @author wkf
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("blog_article")
@ApiModel(value="Article对象", description="博客_文章")
public class Article extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "对应用户id")
    private Integer userId;

    @ApiModelProperty(value = "分类id")
    private Integer categoryId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "阅览量")
    private Integer readCount;


}
