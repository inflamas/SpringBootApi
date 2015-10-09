package api.Service.Authentication;

import api.Entity.User;
import api.Entity.Ban;
import api.Exception.UserNotFoundException;
import api.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User authenticateUser(String username) throws UserNotFoundException {
        User user = this.userRepository.findByUsername(username);

        return user;
    }
}
