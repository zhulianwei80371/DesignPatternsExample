package patters.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;
import patters.springaop.UserValidator;
import patters.springaop.impl.UserValidatorImpl;

// 引入
@Component
@Aspect
public class MyAspectINtroduction {

    @DeclareParents( // 定义引入赠强
    value = "patters.springaop.impl.UserServiceImpl",
            defaultImpl = UserValidatorImpl.class)
    // 增强接口
    public UserValidator userValidator;

}
