package com.fun.feifun.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGeneration {




    private static final String DB_URL = "jdbc:mysql://47.108.86.63:3306";
    private static final String DB_NAME = "oa_dev?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Lchuang_2019";
    private static final String[] SUPER_ENTITY_COLUMNS = {"id", "create_time", "update_time", "del_flag"};

    public static void main(String[] args) {
        AutoGenerator mpg =new AutoGenerator();


        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //生成文件输出根目录
        gc.setOutputDir(projectPath+ "/oa_api/src/main/java");
        //作者
        gc.setAuthor("autoCode");
        //生成完成后不弹出文件框
        gc.setOpen(false);
        //生成文件覆盖
        gc.setFileOverride(true);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(false);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);






        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.lc.cloud.api.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));




        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    /**
     * 配置数据库源
     * @return
     */
    public static DataSourceConfig setDataSoruec(){
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //数据库信息查询雷
        //dsc.setDbQuery();
        //数据库
        dsc.setDbType(DbType.MYSQL);
        //驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //实现 ITypeConvert 接口自定义数据库 字段类型 转换为自己需要的 java 类型，内置转换类型无法满足可实现 IColumnType 接口自定义
        //dsc.setTypeConvert();
        //数据库连接路径
        dsc.setUrl(DB_URL);
        //数据库名称
        dsc.setSchemaName(DB_NAME);
        //数据库用户名
        dsc.setUsername(DB_USERNAME);
        //数据库密码
        dsc.setPassword(DB_PASSWORD);
        return dsc;
    }

    public static PackageConfig setPackageConfig(){
        // 包配置
        PackageConfig pc = new PackageConfig();
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("com.fun.feifun.modules");
        //控制器
        pc.setController("controller");
        //服务类接口
        pc.setService("service");
        //服务实现类
        pc.setServiceImpl("impl");
        //数据持久层
        pc.setMapper("dao");
        //
        pc.setEntity("model");
        //
        pc.setXml("xml");
        return  pc;
    }

}
