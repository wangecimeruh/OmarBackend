package omar.trial.services;

import omar.trial.entities.Users;
import omar.trial.repositories.UserInterface;
import omar.trial.repositories.jpa.UserInterfaceJPA;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserInterface {


    private final UserInterfaceJPA userInterfaceJPA;

    public UserService(UserInterfaceJPA userInterfaceJPA) {
        this.userInterfaceJPA = userInterfaceJPA;
    }

    @Override
    public void create(String userName,String phoneNumber, String email, String password) {
        Users user=null;
        user.setUserName(userName);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        userInterfaceJPA.save(user);
    }

}
