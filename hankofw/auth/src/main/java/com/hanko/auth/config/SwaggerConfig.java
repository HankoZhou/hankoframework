package com.hanko.auth.config;

import com.hanko.cmn.config.BaseSwaggerConfig;
import com.hanko.cmn.model.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 *
 * @author hanko
 * @date 2020/4/26
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.hanko.auth.controller")
                .title("auth")
                .description("auth后台相关接口文档")
                .contactName("hanko")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
