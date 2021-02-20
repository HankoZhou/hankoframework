package com.hanko.admin.config;

import com.hanko.admin.BaseTest;
import com.hanko.cmn.services.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hanko
 * @Date: 2021-2-20 9:01
 */

class RedisConfigTest extends BaseTest {
    @Autowired
    RedisService redisService;
    @Test
    void test_redis(){
        redisService.set("test_redis","abc");
    }

}
