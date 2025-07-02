package patters.cglibaop;


import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class ProxyBean  implements MethodInterceptor {

    private Object target; // 目标对象
    private Intercept intercept; // 拦截器


    public static Object getProxy(Object target, Intercept intercept) {

        ProxyBean proxyBean = new ProxyBean();
        // 增强者
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setInterfaces(target.getClass().getInterfaces());
        proxyBean.target = target;
        proxyBean.intercept = intercept;
        // 设置代理对象为proxyBean,运行时会回掉代理对象的intercept()方法
        enhancer.setCallbacks(new Callback[]{proxyBean, NoOp.INSTANCE}); // 一个callback可以是MethodInterceptor,也可以是NoOp.INSTANCE

        enhancer.setCallbackFilter(method -> {
            if (method.getName().equals("sayHello")) {
                return 0; // index of your MethodInterceptor
            } else {
                return 1; // index of NoOp.INSTANCE
            }
        });
        Object proxy = enhancer.create();
        return  proxy;
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 回掉对象
        Invocation invocation = new Invocation(this.target,method,args,this.intercept);
        Object result = null;
        if(this.intercept.useAround()){ // 是否启用环绕通知
            result = this.intercept.around(invocation);
        }else{
            result = invocation.proceed();
        }
        // 返回结果
        return result;
    }
}
