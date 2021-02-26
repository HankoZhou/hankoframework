package com.hanko.admin.service.impl;

import com.hanko.admin.mapper.SysPermissionMapper;
import com.hanko.cmn.constant.CacheConstants;
import com.hanko.cmn.entity.SysPermission;
import com.hanko.admin.service.SysPermissionService;
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
public class SysPermissionServiceImpl implements SysPermissionService {
    private final SysPermissionMapper sysPermissionMapper;
    private final RedisService redisService;

    @Override
    public void initPermission() {
        List<SysPermission> permissionList = sysPermissionMapper.selectPermissionListByRoles(null);
        redisService.set(CacheConstants.SYS_PERMISSION,permissionList);
    }
}
