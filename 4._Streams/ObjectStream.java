import java.util.Date;
import java.util.stream.Stream;

import static java.util.stream.Stream.generate;

public class ObjectStream {
    public static void main(String[] args) {
        /*
        Stream<Date> clock = Stream.generate(Date::new);
        clock.forEach(timestamp -> System.out.println(timestamp));
         */

        //Alternativ syntaks
        Stream<Date> clock = Stream.generate(() -> new Date());
        /*
        clock.forEach(timestamp -> {
            System.out.print("And the time is now: ");
            System.out.println(timestamp);
        });
         */
        clock.forEach(System.out::println);
    }
}
