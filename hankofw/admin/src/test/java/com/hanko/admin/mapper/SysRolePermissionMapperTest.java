package com.hanko.admin.mapper;

import com.hanko.admin.BaseTest;
import com.hanko.admin.entity.SysRolePermission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: hanko
 * @Date: 2021-2-3 14:48
 */
class SysRolePermissionMapperTest extends BaseTest {

    @Resource
    SysRolePermissionMapper sysRolePermissionMapper;

    @Test
    void getPermissionByRole() {
       List<SysRolePermission> list =  sysRolePermissionMapper.getPermissionByRole("6,7");
        list.forEach(System.out::println);

    }
}
