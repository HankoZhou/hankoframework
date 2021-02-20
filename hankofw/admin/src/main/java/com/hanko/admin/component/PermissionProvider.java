package com.hanko.admin.component;

import com.hanko.admin.service.SysPermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * 角色与资源对应关系(用户权限)
 *
 * @author hanko
 * @date 2021/2/20
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PermissionProvider {

    private final SysPermissionService sysPermissionService;

    /**
     * 项目启动时把角色与资源对应关系加载至redis
     */
    @PostConstruct
    public void initPermission(){
        log.info("=========加载角色与资源对应关系========");
        sysPermissionService.initPermission();
    }
}
