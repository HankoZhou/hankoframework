package com.hanko.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanko.cmn.entity.SysRolePermission;

import java.util.List;

/**
 * <p>
 * 角色权限关联表 Mapper 接口
 * </p>
 *
 * @author com.hanko.admin
 * @since 2021-02-03
 */
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

    /**
     * 根据角色获取权限列表
     * @param roles
     * @return
     */
    List<SysRolePermission> getPermissionByRole(String roles);


}
