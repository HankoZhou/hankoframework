package com.hanko.cmn.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 角色权限关联表
 * </p>
 *
 * @author com.hanko.admin
 * @since 2021-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRolePermission implements Serializable {

    private  int id;
    /**权限名称**/
    private String name;

    private String roleId;

    private String resourceId;

    private String url;

    private String operate;

}
