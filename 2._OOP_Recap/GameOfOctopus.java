import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class GameOfOctopus implements Runnable{

    private static ArrayList<String> names;

    static {
        try {
            names = FileReader.readFile("2._OOP_Recap/names.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Random rand = new Random();

    @Override
    public void run() {
        String name = generateName();
        Octopus otto = new Octopus(name);
        otto.makeDoActivity();
    }

    private String generateName(){
        return names.get(rand.nextInt(names.size()));
    }
}
