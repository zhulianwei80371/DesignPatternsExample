package patters.cglibaop;//package patterns.cglibaop;

public class TestMain {
    public static void main(String[] args) {
       HelloService helloService  = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxy(helloService, new MyIntercept());
        proxy.sayHello("张三");

        // 调用方法,测试异常情况
//        proxy.sayHello(null);
    }
}

// module-info.java 中
// 运行时 add VM option -> 增加 --add-opens java.base/java.lang=cglib