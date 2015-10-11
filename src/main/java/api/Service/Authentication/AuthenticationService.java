package api.Service.Authentication;

import api.Entity.Authentication;
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
    public Authentication authenticateUser(String username, String password) throws UserNotFoundException {
        User user = this.userRepository.findByUsername(username);
        boolean valid = false;
        if(user.getPassword().equals(password)) {
            valid = true;
        }
        Authentication authentication = new Authentication(user, valid);

        return authentication;
    }
}
