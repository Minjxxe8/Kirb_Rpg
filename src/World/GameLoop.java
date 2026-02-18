package World;

import Core.Kirby;
import Core.Monster;
import Core.MonsterFactory;
import Powers.Power;

import java.util.Scanner;

public class GameLoop {
    private static final int TOTAL_WORLDS = 5;
    private static final int MOBS_PER_WORLD = 5;

    private int currentWorld;
    private Kirby player;
    private boolean gameRunning;
    private Scanner scanner;

    public GameLoop() {
        this.currentWorld = 1;
        this.player = new Kirby();
        this.gameRunning = true;
        this.scanner = new Scanner(System.in);
    }

    private void runWorld(int worldNumber) {
        GameLore lore = new GameLore();
        System.out.println(lore.getWorldLore(worldNumber));
        waitForKey("\nAppuyez sur entrée pour explorer ce monde...");

        System.out.println("\n--- MONDE " + worldNumber + " ---");
        player.showInventory();

        for (int i = 1; i <= MOBS_PER_WORLD && player.isAlive(); i++) {
            System.out.println("\n=== Combat " + i + "/" + MOBS_PER_WORLD + " ===");
            Monster enemy = MonsterFactory.createRandomMonster();
            String abilityName = enemy.getAbility() != null ? enemy.getAbility().getName() : "Aucun";
            System.out.println("Un " + enemy.getName() + " apparait ! Pouvoir : " + abilityName);

            handleEncounter(enemy);

            if (!player.isAlive()) {
                gameRunning = false;
                System.out.println("GAME OVER - Monde atteint : " + worldNumber);
                return;
            }
        }

        System.out.println("\nMonde " + worldNumber + " terminé !");

        if (worldNumber < TOTAL_WORLDS) {
            Shop shop = new Shop();
            shop.displayShop();
        }

        currentWorld++;
        waitForKey("Appuyez sur entrée pour continuer...");
    }

    private void handleEncounter(Monster enemy) {
        System.out.println("(1) Attaquer | (2) Aspirer");
        String choice = scanner.nextLine();

        if ("2".equals(choice)) {
            if (enemy.getAbility() != null) {
                player.setPower(enemy.getAbility());
                System.out.println("Kirby a aspiré le " + enemy.getName() + " !");
            } else {
                System.out.println("Ce monstre n'a aucun pouvoir à aspirer.");
            }
        } else {
            battle(enemy);
        }
    }

    private void battle(Monster enemy) {
        System.out.println("\n*** COMBAT CONTRE " + enemy.getName().toUpperCase() + " ***");

        while (enemy.isAlive() && player.isAlive()) {
            System.out.println("\n[PV Kirby: " + player.getHp() + "] | [PV Ennemi: " + enemy.getHp() + "]");
            System.out.println("(1) Coup de pied | (2) Pouvoir Spécial | (3) Potion");
            String action = scanner.nextLine();

            switch (action) {
                case "1" -> player.basicAttack(enemy);
                case "2" -> player.useSpecialPower(enemy);
                case "3" -> player.heal();
                default -> System.out.println("Kirby rate son tour.");
            }

            if (!enemy.isAlive()) {
                System.out.println("✓ Victoire ! L'ennemi est vaincu.");
                player.addGold(10);
                break;
            }

            enemy.basicAttack(player);
        }
    }
}
