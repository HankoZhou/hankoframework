package com.hanko.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanko.admin.mapper.SysPermissionMapper;
import com.hanko.cmn.entity.SysPermission;
import com.hanko.admin.entity.SysUser;
import com.hanko.admin.entity.SysUserRole;
import com.hanko.admin.mapper.SysUserMapper;
import com.hanko.admin.mapper.SysUserRoleMapper;
import com.hanko.cmn.model.SysUserDetails;
import com.hanko.admin.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author com.hanko.demo
 * @since 2021-02-02
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysUserMapper sysUserMapper;
    private final SysUserRoleMapper sysUserRoleMapper;
    private final SysPermissionMapper sysPermissionMapper;

    @Override
    public SysUser getUserByUsername(String username) {
        return sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getUsername, username));
    }

    @Override
    public SysUserDetails getUserDetailsByUsername(String username) {
        SysUserDetails sysUserDetails = new SysUserDetails();
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getUsername, username));

        List<String> roles = sysUserRoleMapper.selectList(Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getUserId, sysUser.getId()))
                .stream().map(userRole -> String.valueOf(userRole.getRoleId()))
                .collect(Collectors.toList());

        List<String> permissions = sysPermissionMapper
                .getPermissionListByRoles(String.join(",", roles))
                .stream().map(SysPermission::getUrl)
                .collect(Collectors.toList());

        sysUserDetails.setUsername(sysUser.getUsername());
        sysUserDetails.setPassword(sysUser.getPassword());
        sysUserDetails.setStatus(sysUser.getStatus());
        sysUserDetails.setRoles(roles);
        sysUserDetails.setPermissions(permissions);
        return sysUserDetails;
    }
}
