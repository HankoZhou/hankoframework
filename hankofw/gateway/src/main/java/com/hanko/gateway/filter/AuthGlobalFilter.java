package com.hanko.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.hanko.cmn.constant.AuthConstants;
import com.nimbusds.jose.JWSObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.text.ParseException;

/**
 * 将登录用户的JWT转化成用户信息的全局过滤器
 *
 * @author macro
 * @date 2020/6/17
 */

@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    @SneakyThrows
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(AuthConstants.AUTH_HEADER);
        if (StrUtil.isEmpty(token)) {
            return chain.filter(exchange);
        }
        URI uri = exchange.getRequest().getURI();
        PathMatcher pathMatcher = new AntPathMatcher();
        //过滤掉获取token url
        if (!pathMatcher.match(AuthConstants.AUTH_GET_TOKEN, uri.getPath())) {
            //从token中解析用户信息并设置到Header中去
            String realToken = token.replace(AuthConstants.TOKEN_PREFIX, "");
            JWSObject jwsObject = JWSObject.parse(realToken);
            String userStr = jwsObject.getPayload().toString();
            log.info("AuthGlobalFilter.filter() user:{}", userStr);
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .header(AuthConstants.AUTH_HEADER, userStr).build();
            exchange = exchange.mutate().request(request).build();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
