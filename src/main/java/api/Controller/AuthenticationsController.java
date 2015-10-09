package api.Controller;

import api.Entity.User;
import api.Service.Authentication.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/authentications")
public class AuthenticationsController {

    @Autowired
    private IAuthenticationService service;

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public User authenticateUser(@PathVariable String user) {
        return this.service.authenticateUser(user);
    }
}
