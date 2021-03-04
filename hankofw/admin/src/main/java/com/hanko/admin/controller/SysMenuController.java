package com.hanko.admin.controller;

import cn.hutool.json.JSONUtil;
import com.hanko.admin.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单资源 前端控制器
 * </p>
 *
 * @author hanko
 * @since 2021-02-02
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class SysMenuController {

private final SysMenuService sysMenuService;

    @GetMapping("/list")
    public String menuList() {
        return JSONUtil.toJsonStr(sysMenuService.getMenuTree());
    }
}
