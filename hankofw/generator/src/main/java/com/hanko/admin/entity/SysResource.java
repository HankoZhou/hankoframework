package com.hanko.admin.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 资源总表包括：菜单资源+页面、文件等其它资源
 * </p>
 *
 * @author com.hanko.admin
 * @since 2021-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysResource implements Serializable {


    /**
     * 资源类型(1=菜单，2=其它资源页面/文件等)
     */
    private String type;

    private String name;

    private String resourceId;


}
