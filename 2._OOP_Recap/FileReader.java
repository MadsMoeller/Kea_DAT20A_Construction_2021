import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static ArrayList<String> readFile(String filename) throws FileNotFoundException{
        Scanner load = new Scanner(new File(filename));
        ArrayList<String> list = new ArrayList<>();
        while(load.hasNext()){
            String word = load.next();
            list.add(word);
        }
        return list;
    }

}
