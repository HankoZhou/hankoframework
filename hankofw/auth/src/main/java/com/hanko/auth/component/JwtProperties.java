package com.hanko.auth.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Yangxiufeng
 * @date 2020-10-29
 * @time 10:21
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String keystore;
    private String password;
    private String alias;

}
