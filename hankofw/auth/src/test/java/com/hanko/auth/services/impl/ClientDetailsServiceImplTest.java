package com.hanko.auth.services.impl;

import com.hanko.auth.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: hanko
 * @Date: 2021-2-20 11:57
 */
@Slf4j
class ClientDetailsServiceImplTest extends BaseTest {

    @Autowired
    DataSource dataSource;

    @Test
    void loadClientByClientId() {
        JdbcClientDetailsService jdbcClientDetailsService = new ClientDetailsServiceImpl(dataSource);
        ClientDetails clientDetails = jdbcClientDetailsService.loadClientByClientId("app");
        log.info("clientDetails = {}",clientDetails.toString());

    }
}
