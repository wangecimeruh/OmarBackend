package omar.trial.controllers;

import omar.trial.repositories.UserInterface;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

     UserInterface userServiceI;

//    @PostMapping(value = "/login")
//    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
//        return userServiceI.login(loginRequest);
//    }
}
