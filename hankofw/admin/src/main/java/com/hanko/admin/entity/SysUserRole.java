package com.hanko.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author hanko
 * @since 2021-02-02
 */
@Data
public class SysUserRole implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;


    private Integer roleId;

}
