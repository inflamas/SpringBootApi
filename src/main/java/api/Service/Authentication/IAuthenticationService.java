package api.Service.Authentication;

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
    public User authenticateUser(String user) throws UserNotFoundException;
}
