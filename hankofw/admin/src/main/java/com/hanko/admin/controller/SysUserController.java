package com.hanko.admin.controller;


import com.hanko.admin.service.SysUserService;
import com.hanko.cmn.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hanko
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping("/details/{username}")
    public Result details(@PathVariable("username") String username) {
        return Result.success(sysUserService.getUserDetailsByUsername(username));
    }

    @GetMapping("/info/{username}")
    public Result info(@PathVariable("username") String username) {
        return Result.success(sysUserService.getUserByUsername(username));
    }

    @GetMapping("/list")
    public Result list() {
        return Result.success(sysUserService.list());
    }

}
