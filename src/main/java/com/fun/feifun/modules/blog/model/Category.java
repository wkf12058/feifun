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
 * 
 * </p>
 *
 * @author wkf
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("blog_category")
@ApiModel(value="Category对象", description="")
public class Category extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "关联用户名")
    private Integer userId;

    @ApiModelProperty(value = "父分类id")
    private Integer pId;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "描述")
    private String desc;


}
