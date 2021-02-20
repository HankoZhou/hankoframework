package com.hanko.auth.services.impl;


import cn.hutool.core.util.ArrayUtil;
import com.hanko.auth.model.SecurityUserDetails;
import com.hanko.auth.services.RemoteUserService;
import com.hanko.cmn.constant.AuthConstants;
import com.hanko.cmn.model.Result;
import com.hanko.cmn.model.SysUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * 用户详细信息
 *
 * @author lengleng
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final RemoteUserService remoteUserService;


	/**
	 * 用户密码登录
	 * @param username 用户名
	 * @return
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {
		log.info("================loadUserByUsername======================");
		Result<SysUserDetails> result = remoteUserService.getUserDetailsByUsername(username);
		UserDetails userDetails = getUserDetails(result);
		return userDetails;
	}


	/**
	 * 构建userdetails
	 * @param result 用户信息
	 * @return
	 */
	private UserDetails getUserDetails(Result<SysUserDetails> result) {
		if (result == null || result.getData() == null) {
			throw new UsernameNotFoundException("用户不存在");
		}

		SysUserDetails sysUserDetails = result.getData();
		Set<String> authsSet = new HashSet<>();
		if (ArrayUtil.isNotEmpty(sysUserDetails.getRoles())) {
			// 获取角色
//			sysUserDetails.getRoles().stream().forEach(role -> authsSet.add(AuthConstants.ROLE_PREFIX + role));
			sysUserDetails.getRoles().stream().forEach(role -> authsSet.add(role));

			// 获取资源
//			authsSet.addAll(sysUserDetails.getPermissions());
		}
		Collection<? extends GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(authsSet.toArray(new String[0]));

		// SecurityUserDetails
		UserDetails userDetails = new SecurityUserDetails(sysUserDetails.getUsername(),
				sysUserDetails.getPassword(),
				AuthConstants.USER_NORMAL_STATUS == sysUserDetails.getStatus(),
				authorities);
		log.info("========userDetails===============");
		log.info(userDetails.toString());
		return userDetails;
	}

}
