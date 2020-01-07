package com.fun.feifun.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGeneration {




    private static final String DB_URL = "jdbc:mysql://47.105.71.177:3306/fun?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC";
    private static final String DB_USERNAME = "test";
    private static final String DB_PASSWORD = "bugaosuni@2020";
    private static final String[] SUPER_ENTITY_COLUMNS = {"id", "create_time", "update_time", "is_del"};

    private static  String projectPath = System.getProperty("user.dir");

    public static void main(String[] args) {
        AutoGenerator mpg =new AutoGenerator();


        GlobalConfig gc = globalConfig();
        mpg.setGlobalConfig(gc);

        String module=scanner("模块名称");
        PackageConfig pc = packageConfig(module);
        mpg.setPackageInfo(pc);

        DataSourceConfig dsc = dataSoruec();
        mpg.setDataSource(dsc);

        String[] tableName=scanner("表名，多个英文逗号分割").split(",");
        StrategyConfig sc = strategyConfig(tableName, pc);
        mpg.setStrategy(sc);



        InjectionConfig cfg = injectionConfig(pc);
        mpg.setCfg(cfg);


        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setController("/templates/templateController.java.vm");
        mpg.setTemplate(templateConfig);

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
    public static DataSourceConfig dataSoruec(){
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
        //数据库用户名
        dsc.setUsername(DB_USERNAME);
        //数据库密码
        dsc.setPassword(DB_PASSWORD);
        return dsc;
    }

    /**
     * 包名配置，通过该配置，指定生成代码的包路径
     * @return
     */
    public static PackageConfig packageConfig(String module){
        // 包配置
        PackageConfig pc = new PackageConfig();
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("com.fun.feifun.modules");
        //模块
        pc.setModuleName(module);
        //控制器
        pc.setController("controller");
        //服务类接口
        pc.setService("service");
        //服务实现类
        pc.setServiceImpl("impl");
        //数据持久层
        pc.setMapper("dao");
        //实体类
        pc.setEntity("model");
        //xml
        pc.setXml("xml");
        return  pc;
    }

    /**
     * 包名配置，通过该配置，指定生成代码的包路径
     * @return
     */
    public static GlobalConfig globalConfig()    {
        //全局配置
        GlobalConfig gc = new GlobalConfig();

        //生成文件输出根目录
        gc.setOutputDir(projectPath+ "/src/main/java")
                //生成文件覆盖
                .setFileOverride(true)
                //生成完成后不弹出文件框
                .setOpen(false)
                //作者
                .setAuthor("wkf")
                //实体属性 Swagger2 注解
                .setSwagger2(true)
                // 不需要ActiveRecord特性的请改为false
                .setActiveRecord(false)
                //XML 二级缓存
                .setEnableCache(false)
                // XML ResultMap
                .setBaseResultMap(false)
                // XML columList
                .setBaseColumnList(false)
                //时间类型
                .setDateType(DateType.TIME_PACK)
                //主键策略
                .setIdType(IdType.AUTO);
//                //
//                .setControllerName("%sController")
//                //
//                .setServiceName("%sService")
//                //
//                .setServiceImplName("%sImpl")
//                //
//                .setMapperName("%sMapper")
//                //
//                .setXmlName("%sMapper");


        return gc;
    }


    /**
     * 策略配置
     * @return
     */
    public static StrategyConfig  strategyConfig (String[] tableName,PackageConfig pc){

        StrategyConfig stConfig = new StrategyConfig();
        //全局大写命名
        stConfig.setCapitalMode(true)
                // 数据库表映射到实体的命名策略-是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)
                //数据库表字段映射到实体的命名策略-是否使用下划线
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //自定义继承的Entity类全称，带包名
                .setSuperEntityClass("com.fun.feifun.base.BaseEntity")
                .setSuperEntityColumns(SUPER_ENTITY_COLUMNS)
                //驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                //是否是lombok模型
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                // 生成的表
                .setInclude(tableName)
                //表前缀
                .setTablePrefix(pc.getModuleName()+"_");
        return stConfig;

    }


    public static InjectionConfig injectionConfig(PackageConfig pc){

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义xml
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                String path=projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;

                return path;
            }
        });
        cfg.setFileOutConfigList(focList);
        //自定义Controller
        focList.add(new FileOutConfig("/templates/templateController.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityFile = String.format(( projectPath+pc.getParent()+File.separator+"%s" + ".java"), tableInfo.getControllerName());
                System.out.println("Controller:"+entityFile);
                return entityFile;
            }
        });

        cfg.setFileOutConfigList(focList);



        return  cfg;
    }

}
