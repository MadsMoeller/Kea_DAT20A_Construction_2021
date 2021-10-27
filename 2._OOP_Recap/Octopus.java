import java.util.Random;

import static java.lang.Thread.sleep;

public class Octopus extends Animal{

    private static final Random rand = new Random();
    private static int min = 1;
    private static int max = 10;
    private static int octopodes = 1;

    private String name;

    public Octopus(String name){
        this.name = name;
        System.out.println(name + " the octopus has spawned!");
    }

    public String move(){
        return "Swish swosh";
    }

    public void makeDoActivity() {
        while(octopodes <= 1000){
            try {
                String activity = selectActivity();
                System.out.println(name + " " + activity);
                if(activity.equals("displays mating behaviour")){
                    GameOfOctopus game = new GameOfOctopus();
                    Thread gameThread = new Thread(game);
                    gameThread.start();
                    incrementOctopodes();
                    if(octopodes > 1000){
                        gameThread.join();
                    }
                }
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("It is dead, Jim.");
            }
        }
    }

    private String selectActivity(){
        int act = rand.nextInt(max)+min;
        switch(act){
            case 1:
            case 2:
                return "squirts ink";
            case 3:
                return "displays mating behaviour";
            case 4:
                return "hunts and eats";
            case 5:
                return "dilly dallies on the ocean floor";
            case 6:
                return "broods on the overtaking of world domination";
            default:
                return "swims around: " + move();
        }
    }

    private synchronized void incrementOctopodes(){
        octopodes++;
        System.out.println("Number of octopodes: " + octopodes);
    }
}
