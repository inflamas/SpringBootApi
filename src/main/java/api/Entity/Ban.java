package api.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ban")
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "reason")
    private String reason;

    public static Ban createBan(boolean active, String reason) {
        Ban ban = new Ban();
        ban.active = active;
        ban.reason = reason;

        return ban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
