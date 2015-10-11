package api.Controller;

import api.Entity.Authentication;
import api.Entity.User;
import api.Service.Authentication.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentications")
public class AuthenticationsController {

    @Autowired
    private IAuthenticationService service;

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public Authentication authenticateUser(@PathVariable String user, @RequestHeader(value="User-Password") String userPassword) {
        return this.service.authenticateUser(user, userPassword);
    }
}
