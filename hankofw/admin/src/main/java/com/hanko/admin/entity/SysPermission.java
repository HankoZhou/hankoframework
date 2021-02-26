package com.hanko.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 权限表包括：资源(业务功能、页面、文件等)+操作
 * </p>
 *
 * @author hanko
 * @since 2021-02-03
 */
@Data
public class SysPermission implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String uri;

    private String operate;


}
