package com.hanko.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hanko.admin.BaseTest;
import com.hanko.admin.entity.SysRole;
import com.hanko.admin.entity.SysUser;
import com.hanko.admin.entity.SysUserRole;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: hanko
 * @Date: 2021-2-3 11:21
 */
class SysUserRoleMapperTest extends BaseTest {
    @Resource
    SysUserRoleMapper sysUserRoleMapper;
    @Test
    void user_role(){
        List<SysUserRole> list = sysUserRoleMapper.selectList(Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getUserId, "12345678901234567890"));

        list.forEach(System.out::println);

        list.stream().map(SysUserRole::getRoleId).collect(Collectors.toList()).forEach(System.out::println);
    }

}
