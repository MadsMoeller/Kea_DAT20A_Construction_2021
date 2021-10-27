import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public MethodReference(String content){
        System.out.println(content);
    }

    public MethodReference(){}

    public static void outStatic(String content){
        System.out.println(content);
    }

    public void out(String content){
        System.out.println(content);
    }

    public static void main(String[] args) {
        List<String> greetings = Arrays.asList(
                "When in deadly danger,",
                "when beset by doubt:",
                "run in little circles,",
                "wave your arms and shout!"
        );

        //greetings.forEach((greeting) -> System.out.println(greeting));

        //method reference
        greetings.forEach(new MethodReference()::out);

        //greetings.forEach(MethodReference::outStatic);

        greetings.forEach(MethodReference::new);
    }
}
