package patters.cglibaop;


import java.lang.reflect.Method;

public class Invocation {
    private Object[] params; // 参数
    private Method method; // 方法
    private Object target; // 目标对象
    private Intercept intercept; // 拦截器


    public Invocation(Object target, Method method, Object[] params, Intercept intercept) {
        this.params = params;
        this.method = method;
        this.target = target;
        this.intercept = intercept;
    }

    // 反射方法
    public Object proceed() {
        Object retObj = null; // 返回结果
        boolean exceptionFlag = false; // 异常标志位
        // 调用拦截的before()方法
        this.intercept.before();
        try{
           // 使用反射调用原油方法,并保留返回值
           retObj = method.invoke(target,params);

        }catch (Exception e){
            exceptionFlag = true; // 设置异常标志位
            e.printStackTrace(); // 打印异常信息
        }

        if (exceptionFlag) {
            this.intercept.afterThrowing(); // 异常处理
        }else{
            this.intercept.afterReturning(); // 返回后处理
        }
        this.intercept.after(); // 后置处理
        return retObj; // 返回结果
    }
}
