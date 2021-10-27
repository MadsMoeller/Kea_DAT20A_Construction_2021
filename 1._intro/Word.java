public class Word {
    private String word;

    public Word() {
        word = "";
    }

    public Word(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int length(){
        return word.length();
    }

    public String toString(){
        return word;
    }
}
