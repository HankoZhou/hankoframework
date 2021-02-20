package com.hanko.cmn.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @author hanko
 */
@Data
public class SysUserDetails implements Serializable {

	/**
	 * 用户基本信息
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;


	private int status;

	/**
	 * 权限标识集合
	 */
	private List<String> permissions;

	/**
	 * 角色集合
	 */
	private List<String> roles;

	private int orgnazitionId;

}
