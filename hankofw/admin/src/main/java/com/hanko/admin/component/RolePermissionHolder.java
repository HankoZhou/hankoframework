package com.hanko.admin.component;

import com.hanko.admin.service.SysRolePermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * 资源与角色访问对应关系操作组件
 *
 * @author macro
 * @date 2020/7/17
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RolePermissionHolder {

    private final SysRolePermissionService resourceService;

    @PostConstruct
    public void initResourceRolesMap(){
        log.info("================initResourceRolesMap====================");
        resourceService.initResourceRolesMap();
    }
}
