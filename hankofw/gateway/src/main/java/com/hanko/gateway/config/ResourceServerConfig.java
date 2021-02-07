package com.hanko.gateway.config;

import cn.hutool.core.util.ArrayUtil;
import com.hanko.gateway.properties.IgnoreUrlsProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * 资源服务器配置
 *
 * @author macro
 * @date 2020/6/19
 */
@AllArgsConstructor
@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig {
//    private final AuthorizationManager authorizationManager;
    private final IgnoreUrlsProperties ignoreUrlsProperties;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        //对白名单路径，直接移除JWT请求头
        http.authorizeExchange()
                //白名单配置
                .pathMatchers(ArrayUtil.toArray(ignoreUrlsProperties.getUrls(),String.class)).permitAll()
                .pathMatchers("/admin/**").permitAll()
                //鉴权管理器配置
//                .anyExchange().access(authorizationManager)
                .and().exceptionHandling()
                .and().csrf().disable();
        return http.build();
    }


}
