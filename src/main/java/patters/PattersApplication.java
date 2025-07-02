package patters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import patters.springaop.UserService;
import patters.springaop.UserValidator;

@EnableAspectJAutoProxy
@SpringBootApplication
public class PattersApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PattersApplication.class, args);
//		// 检查切面Bean是否存在
//		System.out.println(ctx.getBean(MyAspect.class));

		UserService bean = ctx.getBean(UserService.class);
		System.out.println("Bean类型: " + bean.getClass());


	}

}
