package api.Security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.common.signature.SignatureSecret;
import org.springframework.security.oauth.provider.ConsumerDetails;
import org.springframework.security.oauth.provider.ExtraTrustConsumerDetails;

public class ApiOAuthConsumerDetails implements ExtraTrustConsumerDetails {

    private static final long serialVersionUID = 1L;
    private final String consumerName;
    private final String consumerKey;
    private final SignatureSecret signatureSecret;
    private final List<GrantedAuthority> authorities;

    public ApiOAuthConsumerDetails(String consumerName, String consumerKey,
                                   String signatureSecret, List<GrantedAuthority> authorities) {
        this.consumerName = consumerName;
        this.consumerKey = consumerKey;
        this.signatureSecret = new SharedConsumerSecretImpl(signatureSecret);
        this.authorities = authorities;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public SignatureSecret getSignatureSecret() {
        return signatureSecret;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public boolean isRequiredToObtainAuthenticatedToken() {
        return false;
    }
}