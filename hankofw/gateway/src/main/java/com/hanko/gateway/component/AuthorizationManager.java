package com.hanko.gateway.component;

import com.hanko.cmn.constant.AuthConstants;
import com.hanko.cmn.constant.CacheConstants;
import com.hanko.cmn.entity.SysPermission;
import com.hanko.cmn.services.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.*;

/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 *
 * @author macro
 * @date 2020/6/19
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    private final IgnoreUrlsProperties ignoreUrlsProperties;
    private final RedisService redisService;
    List<String> authorities;


    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        URI uri = request.getURI();
        PathMatcher pathMatcher = new AntPathMatcher();
        //白名单路径直接放行
        List<String> ignoreUrls = ignoreUrlsProperties.getUrls();
        for (String ignoreUrl : ignoreUrls) {
            if (pathMatcher.match(ignoreUrl, uri.getPath())) {
                return Mono.just(new AuthorizationDecision(true));
            }
        }

        //管理端路径需校验权限
        authorities = new ArrayList<>();
        List<SysPermission> resourceRolesMap = (List<SysPermission>) redisService
                                                .get(CacheConstants.SYS_PERMISSION);
        resourceRolesMap.stream().forEach(r->{
            if (pathMatcher.match(r.getUrl(), uri.getPath())) {
                authorities.add(AuthConstants.ROLE_PREFIX + r.getRoleId());
            }});

        //认证通过且角色匹配的用户可访问当前路径
        //代码一，简捷方式
        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));

        //代码二，详细方式
        /*return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(a -> {
                    return a.getAuthorities();
                })
                .map(g -> {
                    return g.getAuthority();
                })
                .any(c -> {
                    //检测权限是否匹配
                    String[] roles = c.split(",");
                    System.out.println("authorities = " + authorities);
                    System.out.println("roles = " + roles);
                    for (String role : roles) {
                        if (authorities.contains(role)) {
                            return true;
                        }
                    }
                    return false;
                })
                .map(hasAuthority -> new AuthorizationDecision(hasAuthority))
                .defaultIfEmpty(new AuthorizationDecision(false));

*/

    }

}
