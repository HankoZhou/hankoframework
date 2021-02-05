package com.hanko.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanko.admin.BaseTest;
import com.hanko.admin.entity.SysUser;
import com.hanko.admin.service.SysUserService;
import com.hanko.admin.service.impl.SysUserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hanko
 * @Date: 2021-2-2 12:11
 */

class SysUserMapperTest extends BaseTest {

    @Resource
    SysUserMapper sysUserMapper;

    @Test
    public void insert() {
        SysUser user = new SysUser();
        user.setUsername("hanko");
        user.setNickName("张三");
        user.setPassword("123");
        user.setPhone("123");
        sysUserMapper.insert(user);
    }

    @Test
    public void list(){
        List list = sysUserMapper.selectList(null);
        list.forEach(System.out::println);
    }


    @Test
    public void selectPage(){
        Page page = new Page(1,2);
        IPage pages = sysUserMapper.selectPage(page,null);
        pages.getRecords().forEach(System.out::println);
    }



}
