import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        //Anonymous class
        AbstractClass abstractClassImplemented = new AbstractClass() {
            @Override
            public void makeSurrealArt() {
                System.out.println("Created by Dali");
            }
        };
        abstractClassImplemented.makeSurrealArt();

        //Implementation of a (functional) interface
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                return firstString.compareTo(secondString);
            }
        };

        System.out.println(comparator.compare("a", "b"));

        Comparator<String> lambdaComparator = (String firstString, String secondString) -> firstString.compareTo(secondString);
        System.out.println(lambdaComparator.compare("a", "b"));

        Concatenator concat = new Concatenator() {
            @Override
            public String cat(String firstString, String secondString) {
                return firstString + secondString;
            }
        };

        System.out.println(concat.cat("a", "b"));

        Concatenator lambdaConcat = (prependorString, apendorString) -> {
            return prependorString + apendorString;
        };
        System.out.println(lambdaConcat.cat("a", "b"));
    }
}
