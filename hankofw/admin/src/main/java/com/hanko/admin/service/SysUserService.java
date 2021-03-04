package com.hanko.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanko.admin.entity.SysUser;
import com.hanko.cmn.model.SysUserDetails;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author hanko
 * @since 2021-02-02
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * @param sysUser
     * @return
     */
    int saveUser(SysUser sysUser);

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
