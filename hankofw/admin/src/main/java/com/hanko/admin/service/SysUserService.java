package com.hanko.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanko.admin.entity.SysUser;
import com.hanko.cmn.model.SysUserDetails;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author com.hanko.demo
 * @since 2021-02-02
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * loadUserByUsername
     * @param username
     * @return
     */
    SysUser getUserByUsername(String username);


    /**
     * @param username
     * @return
     */
    SysUserDetails getUserDetailsByUsername(String username);

}
