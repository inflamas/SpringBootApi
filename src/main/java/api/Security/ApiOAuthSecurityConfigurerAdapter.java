package api.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth.provider.OAuthProcessingFilterEntryPoint;
import org.springframework.security.oauth.provider.nonce.InMemoryNonceServices;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;

@Configuration
public class ApiOAuthSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private ZeroLeggedOAuthProviderProcessingFilter zeroLeggedOAuthProviderProcessingFilter;
    @Autowired
    ApiOAuthConsumerDetailsService oauthConsumerDetailsServiceApi;
    @Autowired
    ApiOAuthAuthenticationHandler oauthAuthenticationHandler;
    @Autowired
    OAuthProcessingFilterEntryPoint oauthProcessingFilterEntryPoint;
    @Autowired
    OAuthProviderTokenServices oauthProviderTokenServices;
    @PostConstruct
    public void init() {
        zeroLeggedOAuthProviderProcessingFilter = new ZeroLeggedOAuthProviderProcessingFilter(
                oauthConsumerDetailsServiceApi,
                new InMemoryNonceServices(),
                oauthProcessingFilterEntryPoint,
                oauthAuthenticationHandler,
                oauthProviderTokenServices);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .addFilterBefore(zeroLeggedOAuthProviderProcessingFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().anyRequest().hasRole("OAUTH");
    }
}