package patters.cglibaop;

// 自定义拦截器接口
public interface Intercept {

    public void before(); // 前置处理
    public void after();  // 后置处理
    public Object around(Invocation invocation); // 环绕处理

    public void afterReturning(); // 返回后处理
    public void afterThrowing();  // 异常处理
    public default boolean useAround() {
        return false; // 默认使用环绕处理
    }
}
