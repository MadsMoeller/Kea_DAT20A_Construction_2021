public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Octopus otto = new Octopus();
        //System.out.println(otto.isAlive());
        //System.out.println(otto.move());
        //otto.makeDoActivity();

        GameOfOctopus game = new GameOfOctopus();
        Thread gameThread = new Thread(game);
        gameThread.start();
        gameThread.join();
        throw new OctopusOverflowException("I've had it with these goddamn octopodes in this goddamn console!");
    }
}
