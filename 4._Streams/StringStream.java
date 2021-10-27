import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStream {
    public static void main(String[] args) {
        List<String> coolWords = Arrays.asList("Cool", "Ice-cream", "Penguin", "Glacier", "Slush-ice", "Penguin", "", "Penguin");
        System.out.println(coolWords);

        List<String> onlyWords = coolWords.stream().filter(word -> !word.isEmpty()).collect(Collectors.toList());
        System.out.println(onlyWords);

        int vocabulary = (int) coolWords.stream().filter(word -> !word.isEmpty()).distinct().count();
        System.out.println(vocabulary);

        String sentence = coolWords
                .parallelStream()
                .filter(word -> !word.equals(""))
                .collect(Collectors.joining(" ")) + ".";
        System.out.println(sentence);

        System.out.println(Arrays.asList(coolWords.stream().filter(word -> !word.isEmpty()).toArray(String[]::new)));
    }

}
