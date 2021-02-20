package com.hanko.auth.model;

import com.hanko.cmn.constant.AuthConstants;
import com.hanko.cmn.model.SysUserDetails;
import lombok.Getter;
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

    /**
     * Todo 增加自定义的用户属性
     */
    @Getter
    private int organizationId;

    /**
     *
     * @param sysUserDetails
     * @param authorities
     */
    public SecurityUserDetails(SysUserDetails sysUserDetails,Collection<? extends GrantedAuthority> authorities) {
        super(sysUserDetails.getUsername(), sysUserDetails.getPassword(),
                AuthConstants.USER_NORMAL_STATUS == sysUserDetails.getStatus(),
                true, true, true, authorities);
        this.organizationId = sysUserDetails.getOrgnazitionId();
    }


}
