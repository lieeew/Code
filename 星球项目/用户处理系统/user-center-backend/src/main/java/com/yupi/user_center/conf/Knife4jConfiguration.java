package com.yupi.user_center.conf;

/**
 * @author <a href="https://github.com/lieeew">leikooo</a>
 * @date 2024/9/20
 * @description
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * knife4j 配置类，集成了 swagger
 *
 * @author leikooo
 */
@Configuration
@EnableSwagger2WebMvc
// 让这个 bean 只在本地运行
public class Knife4jConfiguration {

    @Bean
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("用户匹配系统")
                        .termsOfServiceUrl("https://github.com/lieeew")
                        .contact("xx@qq.com")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("2.0版本")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.yupi.user_center.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
