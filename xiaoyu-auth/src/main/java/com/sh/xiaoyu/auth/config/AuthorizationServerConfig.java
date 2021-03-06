package com.sh.xiaoyu.auth.config;

import com.sh.xiaoyu.common.base.constants.GlobalsConstants;
import com.sh.xiaoyu.common.security.component.ShWebResponseExceptionTranslator;
import com.sh.xiaoyu.common.security.config.JwtTokenEnhancer;
import com.sh.xiaoyu.common.security.properties.SecurityProperties;
import com.sh.xiaoyu.common.security.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.Arrays;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.auth.config
 * @ClassName: AuthorizationServerConfig
 * @Description: ????????????
 * @Version: 1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private ClientDetailsService clientDetailsService;


    /**
     *  ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    /**
     * ???????????????????????????
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // ?????????jwt??????token??????
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));
        //?????????????????????
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailService)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                //??????token????????????
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                // ?????????jwt??????token??????
                .tokenEnhancer(tokenEnhancerChain)
                // ??????TokenServices?????? ?????????????????????uuid??????????????????
                // .tokenServices(defaultTokenServices())
                .reuseRefreshTokens(false)
                //?????????????????????
                .exceptionTranslator(new ShWebResponseExceptionTranslator());
    }


    /**
     * ???????????????token???????????????jwt???
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new JwtTokenEnhancer();
    }

    /**
     * ??????????????????TokenServices????????????????????????@Primary???????????????
     */
//     @Primary
//     @Bean
//     public DefaultTokenServices defaultTokenServices() {
//         DefaultTokenServices tokenServices = new DefaultTokenServices();
//         tokenServices.setTokenStore(tokenStore());
//         tokenServices.setAuthenticationManager(authenticationManager);
//         // ?????????????????????false???????????????refresh_token?????????????????????token????????????????????????true
//         tokenServices.setSupportRefreshToken(true);
//         // ????????????RefreshToken????????????????????? ?????????true
//         tokenServices.setReuseRefreshToken(false);
//         // token?????????????????????????????????12??????
//         tokenServices.setAccessTokenValiditySeconds(securityProperties.getOauth2().getClients()[0].getAccessTokenValidatySeconds());
//         // refresh_token??????30???
//         tokenServices.setRefreshTokenValiditySeconds(securityProperties.getOauth2().getClients()[0].getRefreshTokenValiditySeconds());
//         tokenServices.setTokenEnhancer(tokenEnhancer());
//         return tokenServices;
//     }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                // ??????/oauth/token_key???????????????????????????
                .tokenKeyAccess("permitAll()")
                // ??????/oauth/check_token??????????????????????????????
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(passwordEncoder)
                //??????????????????
                .allowFormAuthenticationForClients();
    }

    /**
     * ???Jwt??????????????????????????????
     * JwtAccessTokenConverter??????Jwt?????????????????????????????????
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        //?????????,??????????????????????????????????????????????????????????????????,??????????????????RSA?????????????????????
        accessTokenConverter.setSigningKey(GlobalsConstants.OAUTH_SIGNING_KEY);
        return accessTokenConverter;
    }

    /**
     * token store
     */
    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(connectionFactory);
        redisTokenStore.setPrefix(GlobalsConstants.PROJECT_PREFIX+GlobalsConstants.OAUTH_PREFIX);
        return redisTokenStore;
               // return new JwtTokenStore(accessTokenConverter());
    }

}
