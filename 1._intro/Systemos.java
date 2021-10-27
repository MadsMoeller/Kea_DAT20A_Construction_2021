import java.util.List;

public class Systemos {

    static Out out = new Out();

    public static class Out {

        public void println (String s){
            System.out.println(s);
        }

        public void println (int integerToPrint){
            System.out.println(integerToPrint);
        }

        public void println(double doubleToPrint){
            System.out.println(doubleToPrint);
        }

        public void println(List list){
            //list.forEach(object -> println(object));
            list.forEach(System.out::println);
        }

        public void println(Object[] objectsToPrint){
            for (Object object:objectsToPrint) {
                println(object);
            }
        }

        public void println(Object objectToPrint) {System.out.println(objectToPrint);}
    }
}
