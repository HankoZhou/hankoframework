package com.hanko.admin.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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


    private String roleId;

    private String permissionId;


}
