package com.hanko.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanko.admin.entity.SysMenu;
import com.hanko.admin.mapper.SysMenuMapper;
import com.hanko.admin.model.MenuNode;
import com.hanko.admin.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单资源 服务实现类
 * </p>
 *
 * @author hanko
 * @since 2021-02-02
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    private final SysMenuMapper sysMenuMapper;

    @Override
    public List<MenuNode> getMenuTree() {
        List<SysMenu> menuList = sysMenuMapper.selectList(null);
        List<MenuNode> menuNodeList = menuList.stream()
                .filter(menu -> menu.getParentId().equals(-1))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return menuNodeList;
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
