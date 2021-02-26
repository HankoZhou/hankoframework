package com.hanko.admin.service;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanko.admin.BaseTest;
import com.hanko.admin.entity.SysUser;
import com.hanko.admin.entity.SysUserRole;
import com.hanko.admin.vo.UserVO;
import com.hanko.cmn.model.SysUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * @Author: hanko
 * @Date: 2021-2-2 10:59
 */
class SysUserServiceTest extends BaseTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void add() {
        SysUser user = new SysUser();
        String id = "02";
        user.setUsername("zhangsan"+id);
        user.setPassword("123456");
        user.setNickName("张三"+id);
        user.setPhone("15900000000");
        sysUserService.saveUser(user);
    }

    @Test
    void user_list(){
        List<SysUser> list = sysUserService.list();
        list.forEach(System.out::println);
    }

    @Test
    void getUserListByPage(){
        UserVO userVO = new UserVO();
        userVO.setUsername("a");
        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.<SysUser>lambdaQuery();
        queryWrapper.like(SysUser::getUsername,userVO.getUsername());
        Page page = new Page(1,2);
        IPage<SysUser> pages = sysUserService.page(page,queryWrapper);
        pages.getRecords().forEach(System.out::println);
    }

    @Test
    void getUserDetailsByUsername(){
        SysUserDetails sysUserDetails = sysUserService.getUserDetailsByUsername("hanko");
        System.out.println("sysUserDetails = " + sysUserDetails);
    }


}
