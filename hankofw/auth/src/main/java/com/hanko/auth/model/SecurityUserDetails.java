package com.hanko.auth.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


/**
 * 登录用户信息
 *
 * @author hanko
 * @date 2020/6/19
 */

public class SecurityUserDetails extends User {

    //增加自定义的用户属性

    /**
     *
     * @param username
     * @param password
     * @param enabled
     * @param authorities
     */

    public SecurityUserDetails(String username, String password, boolean enabled,Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, true, true, true, authorities);
    }


}
