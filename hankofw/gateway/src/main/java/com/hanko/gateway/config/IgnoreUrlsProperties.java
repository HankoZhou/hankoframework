package com.hanko.gateway.config;

import com.hanko.cmn.model.BaseIgnoreProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hanko
 * @date 2020-10-29
 */
@Data
@Component
@ConfigurationProperties(prefix = "security.ignore")
public class IgnoreUrlsProperties extends BaseIgnoreProperties {
    private List<String> urls;

}
