package com.hanko.admin.service.impl;

import com.hanko.cmn.entity.SysRolePermission;
import com.hanko.admin.mapper.SysRolePermissionMapper;
import com.hanko.admin.service.SysRolePermissionService;
import com.hanko.cmn.constant.AuthConstants;
import com.hanko.cmn.services.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: hanko
 * @Date: 2021-2-19 17:54
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    private final SysRolePermissionMapper sysRolePermissionMapper;
    private final RedisService redisService;

    @Override
    public void initResourceRolesMap() {
        log.info("==============SysRolePermissionServiceImpl=====================");
        List<SysRolePermission> rolePermissionList = sysRolePermissionMapper.getPermissionByRole(null);
        redisService.set(AuthConstants.RESOURCE_ROLES_MAP_KEY,rolePermissionList);
    }
}
