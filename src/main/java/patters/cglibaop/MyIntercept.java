package patters.cglibaop;

public class MyIntercept implements  Intercept{
    @Override
    public void before() {
        System.out.println("before");
    }

    @Override
    public void after() {
        System.out.println("after");
    }

    @Override
    public Object around(Invocation invocation) {
        System.out.println("around before");
        Object object =invocation.proceed();
        System.out.println("around after");
        return object;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }
}
