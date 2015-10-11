package api.Entity;

/**
 *
 */
public class Authentication {

    private User user;

    private boolean valid;

    public Authentication(User user, boolean valid) {
        this.user = user;
        this.valid = valid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
