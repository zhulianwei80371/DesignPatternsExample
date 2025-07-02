package patters.springaop.impl;

import patters.springaop.User;
import patters.springaop.UserValidator;

public class UserValidatorImpl implements UserValidator {
    @Override
    public Boolean vaidate(User user) {
        System.out.printf("引入新的接口:" + UserValidator.class.getSimpleName());
        return user!=null;
    }
}
