package com.fun.feifun.modules.sys.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * <p>
 * 系统配置 前端控制器
 * </p>
 *
 * @author autoCode
 * @since 2019-09-04
 */
@Api(tags = "系统配置")
@RestController
@RequestMapping("/sys/config")
public class ConfigController  {
    @Autowired

    @ApiOperation(value = "配置列表")
    @GetMapping("/v1/list")
    public String list() {
        return "成功";
    }


}
