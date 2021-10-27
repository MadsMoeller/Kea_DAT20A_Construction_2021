import java.util.Random;

public class RandomStream {
    public static void main(String[] args) {
        Random rand = new Random();
        rand.ints().limit(4).forEach(System.out::println);
        //rand.ints().limit(4).forEach((number) -> System.out.println(number));
    }
}
