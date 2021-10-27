import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Systemos.out.println("Print me!");
        Systemos.out.println(5);
        Systemos.out.println(5.00);
        Systemos.out.println(new Word("Bord"));
        System.out.println();
        Word[] words = {new Word("Cucumber"), new Word("Banana"), new Word("Conglomerate"), new Word("Genocide"), new Word("Dolphin")};
        Systemos.out.println(words);

        System.out.println();

        ArrayList<Word> advancedWords = new ArrayList<>();
        advancedWords.add(new Word("Gulerod"));
        advancedWords.add(new Word("Væltepeter"));
        advancedWords.add(new Word("Ordforråd"));
        advancedWords.add(new Word("Spam"));
        advancedWords.add(new Word("Nissefar"));
        advancedWords.add(new Word("For each-loop"));
        advancedWords.add(new Word("Helikopter"));

        Systemos.out.println(advancedWords);
    }


    // generics
    /*
    public static <T> void out (T content){
        System.out.println(content);
    }
    */
}
