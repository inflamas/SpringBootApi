package api.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth.provider.OAuthProcessingFilterEntryPoint;
import org.springframework.security.oauth.provider.token.InMemoryProviderTokenServices;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenServices;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiOAuthProcessingFilterEntryPointImpl extends OAuthProcessingFilterEntryPoint {

    final static Logger log = LoggerFactory.getLogger(ApiOAuthProcessingFilterEntryPointImpl.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        log.info("OAuth FILTER Failure (commence), req=" + request + ", ex=" + authException);
        // Called when there is an OAuth Auth failure, authException may be InsufficientAuthenticationException
        super.commence(request, response, authException);
    }
}