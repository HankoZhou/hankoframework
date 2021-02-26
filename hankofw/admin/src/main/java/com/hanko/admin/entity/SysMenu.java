package com.hanko.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单资源
 * </p>
 *
 * @author hanko
 * @since 2021-02-02
 */
@Data
public class SysMenu implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID
     */
    private Integer parentId;

    /**
     * 菜单URI
     */
    private String uri;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 状态标记(0--删除 1--正常)
     */
    private Integer status;


}
