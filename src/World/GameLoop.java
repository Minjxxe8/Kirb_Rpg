package World;
import java.util.Scanner;

public class GameLoop {
    private static final int TOTAL_WORLDS = 5;
    private static final int MOBS_PER_WORLD = 5;

    private int currentWorld;
    private String currentPower;
    private int kirbyGold;
    private boolean gameRunning;
    private Scanner scanner;

    public GameLoop(){
        this.currentWorld = 1;
        this.currentPower = "Aucun pouvoir";
        this.kirbyGold = 0;
        this.gameRunning = true;
        this.scanner = new Scanner(System.in);
    }
    public static void main(String[] args) {
        GameLoop game = new GameLoop();
        game.start();
    }
    public void start() {
        printBanner();
        waitForKey("\n Appuiyé sur entrée pour commencer...");

        while(gameRunning && currentWorld <= TOTAL_WORLDS) {
            runWorld(currentWorld);
        }
        if (!gameRunning) {
            printLine("=", 50);
            System.out.println("Tu as quitter la partie. À bientôt !");
            printLine("=", 50);
        }
        else{
            printVictory();
        }
        scanner.close();
    }

    private void printBanner() {
        printLine("=", 50);
        System.out.println("                KIRBY RPG GAME        ");
        printLine("=", 50);
    }

    private void printLine(String character, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(character);
        }
        System.out.println();
    }

    private void waitForKey(String message) {
        System.out.print(message);
        scanner.nextLine();
    }

    private void runWorld(int worldNumber) {
        System.out.println("\n--- MONDE " + worldNumber + " ---");
        System.out.println("Pouvoir actuel: " + currentPower);
        System.out.println("Or de Kirby: " + kirbyGold);

        currentWorld++;

        System.out.println("\nMonde " + worldNumber + " terminé!");
        waitForKey("Appuyez sur entrée pour continuer...");
    }

    private void printVictory() {
        printLine("*", 50);
        System.out.println("    FÉLICITATIONS ! Tu as terminé tous les mondes !");
        System.out.println("    Or total: " + kirbyGold);
        printLine("*", 50);
    }
}
