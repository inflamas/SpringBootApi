package api.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth.provider.ConsumerAuthentication;
import org.springframework.security.oauth.provider.ConsumerCredentials;
import org.springframework.security.oauth.provider.OAuthAuthenticationHandler;
import org.springframework.security.oauth.provider.token.OAuthAccessProviderToken;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;


@Component
public class ApiOAuthAuthenticationHandler implements OAuthAuthenticationHandler {
    final static Logger log = LoggerFactory.getLogger(ApiOAuthAuthenticationHandler.class);

    static SimpleGrantedAuthority userGA = new SimpleGrantedAuthority("ROLE_USER");

    @Override
    public Authentication createAuthentication(HttpServletRequest request,
                                               ConsumerAuthentication authentication,
                                               OAuthAccessProviderToken authToken) {
        Collection<GrantedAuthority> authorities = new HashSet<>(authentication.getAuthorities());
        String username = authentication.getName();
        authorities.add(userGA);

        Principal oauthPrincipal = new ConsumerAuthentication(
                authentication.getConsumerDetails(),
                authentication.getConsumerCredentials()
        );

        Authentication auth = new UsernamePasswordAuthenticationToken(oauthPrincipal, null, authorities);

        return auth;
    }
}