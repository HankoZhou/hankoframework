package com.hanko.admin.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author hanko
 * @since 2019/2/1
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRole implements Serializable {

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 角色ID
	 */
	private Integer roleId;

}
