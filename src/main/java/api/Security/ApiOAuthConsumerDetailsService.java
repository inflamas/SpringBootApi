package api.Security;

import api.Model.OAuthRepository;
import api.Entity.Oauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth.common.OAuthException;
import org.springframework.security.oauth.provider.ConsumerDetails;
import org.springframework.security.oauth.provider.ConsumerDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOAuthConsumerDetailsService implements ConsumerDetailsService {
    String consumerName = "John";
    String consumerKey = "3a4393c3da1a4e316ee66c0cc61c71";
    String consumerSecret = "fe1372c074185b19c309964812bb8f3f2256ba514aea8a318";


    @Autowired
    private OAuthRepository oauthRepository;

    public ApiOAuthConsumerDetailsService() {}


    @Override
    public ConsumerDetails loadConsumerByConsumerKey( String consumerKey ) throws OAuthException {

        if( consumerKey == null ) {
            throw new OAuthException("No credentials found for the consumer key [" + consumerKey + "]");
        }

        Oauth oauth = this.oauthRepository.findByConsumerKey(consumerKey);

        if( !consumerKey.equals( oauth.getConsumerKey() ) ) {
            throw new OAuthException("No credentials found for the consumer key [" + consumerKey + "]");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add( new SimpleGrantedAuthority("ROLE_OAUTH") );

        return new ApiOAuthConsumerDetails(
                consumerName,
                consumerKey,
                consumerSecret,
                authorities );
    }

}