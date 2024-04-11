package com.test.cloud.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;

public class Generator {
    public static void generator() {
        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/cloudtest?" +
                                "useSSL=false&" +
                                "useUnicode=true&" +
                                "characterEncoding=utf-8&" +
                                "serverTimezone=UTC",
                        "root",
                        "123.com")
                //全局配置
                .globalConfig(builder -> {
                    builder
                            .author("LastRailgun")              //作者
                            .dateType(DateType.ONLY_DATE)       //日期雷香
                            .commentDate("yyyy-MM-dd")   //日期格式
                            //生成文件绝对路径
                            .outputDir("D:\\Practices\\Idea\\CloudTest\\mybatis_generator\\src\\main\\java")
                            //不抽象业务接口
                            .disableServiceInterface()
                            //生成完毕不打开文件资源管理器
                            .disableOpenDir();
                })
                //包配置
                .packageConfig(builder -> {
                    builder
                            .parent("com.test.cloud")   //父包
                            .entity("entities")         //实体类包
                            .mapper("mapper")           //mapper包
                            .xml("mapper");             //mapper.xml包
                })
                //生成策略配置
                .strategyConfig(builder -> {
                    builder
                            .addFieldPrefix("t_")           //过滤表前缀
                            .entityBuilder()
                            .enableLombok()                 //启用lombok注解
                            .enableTableFieldAnnotation()   //为字段添加TableField注解
                            .naming(NamingStrategy.underline_to_camel)          //根据表名转换实体类名格式
                            .columnNaming(NamingStrategy.underline_to_camel)    //根据表字段名转换实体类字段名格式
                            .idType(IdType.AUTO)            //id生成策略
                            .formatFileName("%s")           //格式化文件名
                            //填充时间列
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
//                            .enableColumnConstant()生成字段常量,用于状态表示
                            .enableActiveRecord()
                            .mapperBuilder()
                            .enableMapperAnnotation()   //启用mapper注解
                            .enableBaseColumnList()     //生成基础列
                            .enableBaseResultMap()      //生成基础结果集映射
                            .formatMapperFileName("%sMapper")   //格式化mapper名称
                            .formatXmlFileName("%sMapper");     //格式化mapper.xml名称
                })
                //生成
                .execute();
    }
}
