package com.hanko.auth.services;

import com.hanko.auth.BaseTest;
import com.hanko.cmn.model.Result;
import com.hanko.cmn.model.SysUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hanko
 * @Date: 2021-2-3 17:27
 */
@Slf4j
class RemoteUserServiceTest extends BaseTest {

    @Autowired
    RemoteUserService remoteUserService;

    @Test
    void getUserDetailsByUsername() {
        Result<SysUserDetails>  user = remoteUserService.getUserDetailsByUsername("hanko");
        log.info(user.getData().toString());
    }



}
