package api.Security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth.provider.OAuthProcessingFilterEntryPoint;
import org.springframework.security.oauth.provider.filter.ProtectedResourceProcessingFilter;
import org.springframework.security.oauth.provider.nonce.OAuthNonceServices;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenServices;

public class ZeroLeggedOAuthProviderProcessingFilter extends ProtectedResourceProcessingFilter {

    final static Logger log = LoggerFactory.getLogger(ApiOAuthSecurityConfigurerAdapter.class);

    ZeroLeggedOAuthProviderProcessingFilter(
            ApiOAuthConsumerDetailsService apiOAuthConsumerDetailsService,
            OAuthNonceServices oAuthNonceServices,
            OAuthProcessingFilterEntryPoint oAuthProcessingFilterEntryPoint,
            ApiOAuthAuthenticationHandler oAuthAuthenticationHandler,
            OAuthProviderTokenServices oAuthProviderTokenServices) {
        super();
        log.info("CONSTRUCT Zero Legged OAuth provider");
        setAuthenticationEntryPoint(oAuthProcessingFilterEntryPoint);
        setAuthHandler(oAuthAuthenticationHandler);
        setConsumerDetailsService(apiOAuthConsumerDetailsService);
        setNonceServices(oAuthNonceServices);
        setTokenServices(oAuthProviderTokenServices);
        //setIgnoreMissingCredentials(false); // die if OAuth params are not included
    }
}
