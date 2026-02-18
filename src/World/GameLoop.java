package World;

import Core.Kirby;
import Core.Monster;
import Core.Boss;
import Core.Entity;
import java.util.Scanner;

public class GameLoop {
    private static final int TOTAL_WORLDS = 5;

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

    private void waitForKey(String message) {
        System.out.println(message);
        scanner.nextLine();
    }

    public void start() {
        GameLore lore = new GameLore();
        System.out.println(lore.getIntroduction());

        while (gameRunning && currentWorld <= TOTAL_WORLDS) {
            runWorld(currentWorld);
        }

        if (currentWorld > TOTAL_WORLDS && player.isAlive()) {
            System.out.println("\n*** FÉLICITATIONS ! Vous avez terminé tous les mondes ! ***");
        }

        scanner.close();
    }


    private void runWorld(int worldNumber) {
        GameLore lore = new GameLore();
        System.out.println(lore.getWorldLore(worldNumber));
        waitForKey("\nAppuyez sur entrée pour explorer ce monde...");

        System.out.println("\n--- MONDE " + worldNumber + " ---");
        player.showInventory();

        String[] monsterNames = {"Waddle Dee", "Waddle Doo", "Bronto Burt"};

        for (int i = 0; i < monsterNames.length; i++) {
            System.out.println("\n=== Combat " + (i + 1) + " du Monde " + worldNumber + " ===");
            Monster enemy = new Monster(monsterNames[i]);
            String abilityName = enemy.getAbility() != null ? enemy.getAbility().getName() : "Aucun";
            System.out.println("Un " + enemy.getName() + " apparait ! Pouvoir : " + abilityName);

            handleEncounter(enemy);

            if (!player.isAlive()) {
                gameRunning = false;
                System.out.println("GAME OVER - Monde atteint : " + worldNumber);
                return;
            }

            if (i < monsterNames.length - 1) {
                waitForKey("\nAppuyez sur entrée pour continuer l'exploration...");
            }
        }

        System.out.println("\n=== COMBAT DE BOSS ===");
        Boss boss = new Boss("Boss du Monde " + worldNumber);
        System.out.println("Un " + boss.getName() + " apparait avec " + boss.getHp() + " PV !");

        battle(boss);

        if (!player.isAlive()) {
            gameRunning = false;
            System.out.println("GAME OVER - Vaincu par le boss du monde " + worldNumber);
            return;
        }

        System.out.println("\n*** Boss vaincu ! ***");

        if (worldNumber < TOTAL_WORLDS) {
            Shop shop = new Shop();
            shop.displayShop();
        }
        System.out.println("\nMonde " + worldNumber + " terminé !");

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

    private void battle(Entity enemy) {
        boolean isBoss = enemy instanceof Boss;
        String entityType = isBoss ? "BOSS" : enemy.getName().toUpperCase();

        while (enemy.isAlive() && player.isAlive()) {
            System.out.println("\n[PV Kirby: " + player.getHp() + "] | [PV " + enemy.getName() + ": " + enemy.getHp() + "]");
            System.out.println("(1) Coup de pied | (2) Pouvoir Spécial | (3) Potion");
            String action = scanner.nextLine();

            switch (action) {
                case "1" -> player.basicAttack(enemy);
                case "2" -> player.useSpecialPower(enemy);
                case "3" -> player.heal();
                default -> System.out.println("Kirby rate son tour.");
            }

            if (!enemy.isAlive()) {
                String victoryMessage = isBoss ? "✓ Victoire épique ! Le boss est vaincu !" : "✓ Victoire ! L'ennemi est vaincu.";
                System.out.println(victoryMessage);
                player.addGold(isBoss ? 50 : 10);
                break;
            }

            int damage = (enemy instanceof Boss) ? ((Boss) enemy).attack() : enemy.getDamage();
            player.takeDamage(damage);
            System.out.println(enemy.getName() + " attaque et inflige " + damage + " dégâts !");
        }
    }


}
