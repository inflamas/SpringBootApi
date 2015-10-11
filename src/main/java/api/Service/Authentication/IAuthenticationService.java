package api.Service.Authentication;

import api.Entity.Authentication;
import api.Entity.User;
import api.Exception.UserNotFoundException;

/**
 *
 */
public interface IAuthenticationService {

    /**
     *
     * @param user
     * @return
     */
    public Authentication authenticateUser(String user, String password) throws UserNotFoundException;
}
