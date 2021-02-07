package com.hanko.auth.services.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @Author: hanko
 * @Date: 2021-2-7 16:14
 */
@Slf4j
public class ClientDetailsServiceImpl extends JdbcClientDetailsService {
    public ClientDetailsServiceImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    @SneakyThrows
    public ClientDetails loadClientByClientId(String clientId) {
        log.info("==============loadClientByClientId=====================");
        return super.loadClientByClientId(clientId);

    }
}
