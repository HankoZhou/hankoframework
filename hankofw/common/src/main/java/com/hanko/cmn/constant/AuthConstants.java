package com.hanko.cmn.constant;

/**
 * @author hanko
 * @date 2019/2/1
 */
public interface AuthConstants {

	/**
	 * 角色前缀
	 */
	String ROLE_PREFIX = "ROLE_";

	int USER_NORMAL_STATUS = 1;

	String AUTHORITY_CLAIM_NAME = "authorities";


	/**
	 * 认证信息Http请求头
	 */
	String AUTH_HEADER = "Authorization";

	/**
	 * JWT令牌前缀
	 */
	String TOKEN_PREFIX = "Bearer ";

	String ORGANIZATION_ID = "organization_id";

	String AUTH_GET_TOKEN = "/**/oauth/token";




}
