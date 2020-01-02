package com.fun.feifun.config;

import com.fun.feifun.base.log.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.*;

/**
 *Spring内部配置方式
 *
 */
public class WebMvcConfig implements WebMvcConfigurer {



    @Autowired
    private LogInterceptor logInterceptor;

    /**
     * 拦截器
     * 拦截器主要用途：进行用户登录状态的拦截，日志的拦截等。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                //设置拦截器的过滤路径规则
                .addPathPatterns()
                //设置不需要拦截的过滤规则
                .excludePathPatterns( "/swagger-ui.html/**", "/doc.html/**");
    }

    /**
     * 页面跳转
     * 以前写SpringMVC的时候，如果需要访问一个页面，必须要写Controller类，然后再写一个方法跳转到页面，感觉好麻烦，其实重写WebMvcConfigurer中的addViewControllers方法即可达到效果了
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/toLogin").setViewName("login");
    }

    /**
     * 静态资源
     * 我们想自定义静态资源映射目录的话，只需重写addResourceHandlers方法即可
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                //指的是对外暴露的访问路径
                .addResourceHandler("static/**")
                //指的是内部文件放置的目录
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html");

    }


    /**
     * 跨域
     * 设置一下跨域情况
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }


}
