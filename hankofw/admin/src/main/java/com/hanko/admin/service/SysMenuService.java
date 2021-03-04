package com.hanko.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanko.admin.entity.SysMenu;
import com.hanko.admin.model.MenuNode;

import java.util.List;

/**
 * <p>
 * 菜单资源 服务类
 * </p>
 *
 * @author hanko
 * @since 2021-02-02
 */
public interface SysMenuService extends IService<SysMenu> {
    List<MenuNode>  getMenuTree();

}
