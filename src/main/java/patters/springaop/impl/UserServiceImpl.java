package patters.springaop.impl;

import org.springframework.stereotype.Service;
import patters.springaop.User;
import patters.springaop.UserService;
import patters.springaop.UserValidator;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        System.out.println("I am: " + this.getClass());
        System.out.printf("User name is: %s\n", user.getName());
    }
}
