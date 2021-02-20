package com.hanko.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanko.cmn.entity.SysPermission;

import java.util.List;

/**

 *权限(角色与资源关系)
 * @author hanko
 * @since 2021-02-03
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 根据角色获取权限列表
     * @param roles
     * @return
     */
    List<SysPermission> getPermissionListByRoles(String roles);


}
