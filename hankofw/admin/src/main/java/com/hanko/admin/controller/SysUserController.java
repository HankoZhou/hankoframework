package com.hanko.admin.controller;


import cn.hutool.json.JSONObject;
import com.hanko.admin.service.SysUserService;
import com.hanko.cmn.constant.AuthConstants;
import com.hanko.cmn.model.Result;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


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

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public Result getCurrentUserInfo(HttpServletRequest request) {
        String userStr = request.getHeader(AuthConstants.AUTH_HEADER);
        String username = (String) new JSONObject(userStr).get("user_name");
        return Result.success(sysUserService.getUserDetailsByUsername(username));

    }

    @GetMapping("/list")
    public Result listByPage() {
        return Result.success(sysUserService.list());
    }

}
