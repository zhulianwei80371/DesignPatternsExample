package patters.springaop.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import patters.springaop.User;

// spring boot 默认使用GCLIB动态代理
// spring 接口使用jdk动态代理,否则CGLIB动态代理
// 声明为切面
@Component
@Aspect
public class MyAspect {

    public MyAspect() {
        System.out.println(">>> MyAspect 被实例化了");
    }
    // 通过正则指定连接点(即哪些类的哪些方法)
    private static final String aopExp = "execution(* *..UserServiceImpl.printUser(..))";
    // 使用pointCut定义切点
    @Pointcut("execution(* patters.springaop.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {}

    // 环绕通知 + 通知获取参数(连接点的名称为User的参数传递进行
    @Around("pointCut() && args(user)")
    public  void around(ProceedingJoinPoint pjp, User user) throws Throwable {
        System.out.println(">>> around before");
        // 执行目标方法
        System.out.println(user.getName());
        pjp.proceed();
        System.out.println(">>> around after");
    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after");

    }

    @AfterReturning("pointCut()")
    public void afterReturing(){
        System.out.println("afterReturing");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
}
