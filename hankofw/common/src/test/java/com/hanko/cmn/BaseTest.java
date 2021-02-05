package com.hanko.cmn;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;
/**
 * @Author: hanko
 * @Date: 2021-2-2 10:59
 */
class BaseTest {

    @Test
    void test(){
        Snowflake sf = IdUtil.createSnowflake(1,10);
        System.out.println(sf.nextId());
    }
}
