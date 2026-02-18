package World;

import Core.*;

import java.util.Scanner;

public class GameLoop {
    private static final int TOTAL_WORLDS = 5;

    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String MAGENTA = "\u001B[35m";

    private int currentWorld;
    private final Kirby player;
    private boolean gameRunning;
    private final Scanner scanner;

    public GameLoop() {
        this.currentWorld = 1;
        this.player = new Kirby();
        this.gameRunning = true;
        this.scanner = new Scanner(System.in);
    }

    private String color(String ansi, String text) {
        return ansi + text + RESET;
    }

    private void printTitle(String title) {
        String line = "=".repeat(Math.max(24, title.length() + 8));
        System.out.println();
        System.out.println(color(CYAN, line));
        System.out.println(color(BOLD + CYAN, "   " + title));
        System.out.println(color(CYAN, line));
    }

    private void printSubTitle(String title) {
        System.out.println();
        System.out.println(color(MAGENTA, "---- " + title + " ----"));
    }

    private String hpBar(int hp, int maxHp, int width, String fullColor) {
        int safeHp = Math.max(0, hp);
        int filled = (int) Math.round((safeHp / (double) maxHp) * width);
        filled = Math.max(0, Math.min(width, filled));
        String bar = "#".repeat(filled) + "-".repeat(width - filled);
        return "[" + color(fullColor, bar.substring(0, filled)) + bar.substring(filled) + "]";
    }

    private void printBattleHud(Entity enemy) {
        String kirbyLine = "Kirby  " + hpBar(player.getHp(), player.getMaxHp(), 20, GREEN) + " "
                + player.getHp() + "/" + player.getMaxHp();
        String enemyLine = enemy.getName() + " " + hpBar(enemy.getHp(), enemy.getMaxHp(), 20, RED) + " "
                + enemy.getHp() + "/" + enemy.getMaxHp();

        System.out.println();
        System.out.println(color(BOLD, kirbyLine));
        System.out.println(color(BOLD, enemyLine));
        System.out.println("Potions: " + player.getInventory().getPotionCount() + " | Gold: " + player.getInventory().getGold());
    }

    private void waitForKey(String message) {
        System.out.println(color(YELLOW, message));
        scanner.nextLine();
    }

    public void start() {
        GameLore lore = new GameLore();
        printTitle("KIRBY RPG EDITION TERMINAL");
        System.out.println(lore.getIntroduction());

        while (gameRunning && currentWorld <= TOTAL_WORLDS) {
            runWorld(currentWorld);
        }

        if (currentWorld > TOTAL_WORLDS && player.isAlive()) {
            System.out.println(color(BOLD + GREEN, "\nVictoire ! Vous avez termine tous les mondes."));
        }

        scanner.close();
    }

    private void runWorld(int worldNumber) {
        GameLore lore = new GameLore();
        printTitle("MONDE " + worldNumber);
        System.out.println(lore.getWorldLore(worldNumber));
        waitForKey("Appuyez sur Entree pour explorer ce monde...");

        printSubTitle("Inventaire");
        player.showInventory();

        for (int i = 0; i < 3; i++) {
            printSubTitle("Combat " + (i + 1) + " / 3");
            Monster enemy = MonsterFactory.createRandomMonster();
            String abilityName = enemy.getAbility() != null ? enemy.getAbility().getName() : "Aucun";
            System.out.println(color(MAGENTA, "Un " + enemy.getName() + " apparait !"));
            System.out.println("Pouvoir ennemi : " + abilityName);

            handleEncounter(enemy);

            if (!player.isAlive()) {
                gameRunning = false;
                System.out.println(color(RED, "\nGAME OVER - Monde atteint : " + worldNumber));
                return;
            }

            if (i < 2) {
                waitForKey("Appuyez sur Entree pour continuer...");
            }
        }

        printSubTitle("Combat de Boss");
        Boss boss = new Boss("Boss du Monde " + worldNumber);
        System.out.println(color(RED, "Un " + boss.getName() + " apparait avec " + boss.getHp() + " PV !"));

        battle(boss);

        if (!player.isAlive()) {
            gameRunning = false;
            System.out.println(color(RED, "\nGAME OVER - Vaincu par le boss du monde " + worldNumber + "."));
            return;
        }

        System.out.println(color(BOLD + GREEN, "\nBoss vaincu !"));

        if (worldNumber < TOTAL_WORLDS) {
            Shop shop = new Shop();
            shop.displayShop(player);
        }

        System.out.println(color(BOLD + CYAN, "\nMonde " + worldNumber + " termine."));

        currentWorld++;
        waitForKey("Appuyez sur Entree pour le monde suivant...");
    }

    private void handleEncounter(Monster enemy) {
        System.out.println("Choisissez une action : " + color(CYAN, "(1) Combattre") + " | " + color(CYAN, "(2) Avaler"));
        String choice = scanner.nextLine().trim();

        if ("2".equals(choice)) {
            player.swallowPower(enemy);
        } else {
            battle(enemy);
        }
    }

    private void battle(Entity enemy) {
        boolean isBoss = enemy instanceof Boss;

        while (enemy.isAlive() && player.isAlive()) {
            printBattleHud(enemy);
            System.out.println(color(YELLOW, "Actions : (1) Coup de pied | (2) Pouvoir | (3) Potion"));
            System.out.print("> ");
            String action = scanner.nextLine().trim();

            switch (action) {
                case "1" -> player.basicAttack(enemy);
                case "2" -> player.useSpecialPower(enemy);
                case "3" -> player.heal();
                default -> System.out.println(color(YELLOW, "Action invalide. Tour perdu."));
            }

            if (!enemy.isAlive()) {
                int reward = isBoss ? 50 : 10;
                System.out.println(color(GREEN, isBoss ? "Victoire epique ! Le boss est a terre." : "Victoire ! Ennemi vaincu."));
                player.addGold(reward);
                System.out.println(color(YELLOW, "+" + reward + " or"));
                break;
            }

            int damage = (enemy instanceof Boss) ? ((Boss) enemy).attack() : enemy.getDamage();
            player.takeDamage(damage);
            System.out.println(color(RED, enemy.getName() + " attaque et inflige " + damage + " degats."));
        }
    }
}
