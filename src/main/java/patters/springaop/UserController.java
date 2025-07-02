package patters.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public void testPrintUser() {
        User user = new User();
        user.setName("testName");
        userService.printUser(user); // ✅ 会触发切面

        UserValidator uservalidator = (UserValidator) userService;
        if(uservalidator.vaidate(user)) {
            System.out.println("User is valid");
        } else {
            System.out.println("User is invalid");
        }
    }
}

// 环绕, 引入 DeclareParent
// 参数
// 多切面,
