package api.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;

    @Column(name = "username")
    private String username;

    @OneToOne(optional = false)
    @JoinColumn(name="ban_id")
    private Ban ban;

    public static User createUser(int playerId, String username, Ban ban) {
        User auth = new User();
        auth.playerId = playerId;
        auth.username = username;
        auth.ban = ban;

        return auth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Ban getBan() {
        return ban;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }
}
