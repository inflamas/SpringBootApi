package api.Model;

import api.Entity.Oauth;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "oauthRepository")
public interface OAuthRepository extends CrudRepository<Oauth, Long> {
    public Oauth findByConsumerKey(String consumerKey);
}
