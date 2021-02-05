package com.hanko.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanko.admin.BaseTest;
import com.hanko.admin.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: hanko
 * @Date: 2021-2-2 10:59
 */
class SysUserServiceTest extends BaseTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void insert() {
        SysUser user = new SysUser();
        user.setUsername("小羊");
        user.setPassword("123");
        user.setPhone("123");
        sysUserService.save(user);
    }

    @Test
    void user_list(){
        List<SysUser> list = sysUserService.list();
        list.forEach(System.out::println);
    }

    @Test
    void userByPage(){
        Page page = new Page(1,2);
        IPage<SysUser> pages = sysUserService.page(page);
        pages.getRecords().forEach(System.out::println);
    }


}
