package com.hanko.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author com.hanko.demo
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */

    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 头像
     */
    private String icon;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 帐号启用状态：0->禁用；1->启用

     */
    private Integer status;


}
