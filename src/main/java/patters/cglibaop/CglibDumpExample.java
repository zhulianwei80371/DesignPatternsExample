package patters.cglibaop;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDumpExample {
    public static void main(String[] args) {
        // 设置输出目录
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "out/cglib");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setInterfaces(HelloServiceImpl.class.getInterfaces());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Before method: " + method.getName());
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("After method: " + method.getName());
                return result;
            }
        });

        HelloService proxy = (HelloService) enhancer.create();
        proxy.sayHello("World");
    }
}
// module-info.java 中
// 运行时 add VM option -> 增加 --add-opens java.base/java.lang=cglib

