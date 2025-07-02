package patters.cglibaop;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        System.out.println("Hello, " + name + "!");
    }
}
