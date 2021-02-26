package com.hanko.cmn.constant;

/**
 * @author hanko

 */
public interface CacheConstants {

	/**
	 * oauth 缓存令牌前缀
	 */
	String  ACCESS_TOKEN = "auth:token:";

	/**
	 * Redis缓存权限规则key
	 */
	String SYS_PERMISSION = "auth:permission:";

	String CLIENT_DETAILS = "auth:client_details:";


}
