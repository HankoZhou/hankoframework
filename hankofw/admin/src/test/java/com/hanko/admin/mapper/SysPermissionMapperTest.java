package com.hanko.admin.mapper;

import com.hanko.admin.BaseTest;
import com.hanko.cmn.entity.SysPermission;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.util.List;

/**
 * @Author: hanko
 * @Date: 2021-2-3 14:48
 */
class SysPermissionMapperTest extends BaseTest {

    @Resource
    SysPermissionMapper sysRolePermissionMapper;

    @Test
    void getPermissionByRole() {
       List<SysPermission> list =  sysRolePermissionMapper.selectPermissionListByRoles("6,7");
        list.forEach(System.out::println);

    }
}
