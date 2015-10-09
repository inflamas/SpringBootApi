package api.Entity;

import javax.persistence.*;

@Entity
@Table(name = "oauth")
public class Oauth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "consumerKey")
    private String consumerKey;

    @Column(name = "consumerSecret")
    private String consumerSecret;

    public void setId(Long id) {
        this.id = id;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public Long getId() {
        return id;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getconsumerSecret() {
        return consumerSecret;
    }
}
