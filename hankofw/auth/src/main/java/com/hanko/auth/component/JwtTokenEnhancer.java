package com.hanko.auth.component;

import com.hanko.auth.model.SecurityUserDetails;
import com.hanko.cmn.constant.AuthConstants;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * JWT内容增强器
 *
 * @author hanko
 * @date 2021/2/19
 */
@Component
public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        SecurityUserDetails securityUserDetails = (SecurityUserDetails) authentication.getPrincipal();
        Map<String, Object> info = new HashMap<>();
        //自定义信息加入JWT中
        info.put(AuthConstants.ORGANIZATION_ID, securityUserDetails.getOrganizationId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
