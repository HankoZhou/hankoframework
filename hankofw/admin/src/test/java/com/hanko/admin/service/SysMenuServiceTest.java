package com.hanko.admin.service;

import cn.hutool.json.JSONUtil;
import com.hanko.admin.BaseTest;
import com.hanko.admin.entity.SysMenu;
import com.hanko.admin.model.MenuNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: hanko
 * @Date: 2021-2-24 16:10
 */
@Slf4j
class SysMenuServiceTest extends BaseTest {
    @Autowired
    SysMenuService sysMenuService;
    @Test
    void test_menu_list(){
        List<SysMenu>  menuList = sysMenuService.list();

        List<MenuNode> menuNodeList = menuList.stream()
                .filter(menu -> menu.getParentId().equals(-1))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());

        System.out.println("menuNodeList = " + JSONUtil.toJsonStr(menuNodeList));



    }

    private MenuNode covertMenuNode(SysMenu menu, List<SysMenu> menuList) {
        MenuNode node = new MenuNode();
        BeanUtils.copyProperties(menu, node);
        List<MenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

}
