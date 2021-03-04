package com.hanko.auth.config;

import com.hanko.cmn.model.BaseIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper=true)
public class IgnoreUrlsProperties extends BaseIgnoreProperties {

}
