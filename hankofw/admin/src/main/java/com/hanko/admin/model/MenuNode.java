package com.hanko.admin.model;

import com.hanko.admin.entity.SysMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * 后台菜单节点封装
 *
 * @author macro
 * @date 2020/2/4
 */
@Data
public class MenuNode extends SysMenu {
    @ApiModelProperty(value = "子级菜单")
    private List<MenuNode> children;
}
