package Core;

import java.util.Scanner;

public class Game {
    private final Kirby player;
    private final Scanner scanner;
    private int worldLevel;

    public Game() {
        this.player = new Kirby();
        this.scanner = new Scanner(System.in);
        this.worldLevel = 1;
    }

    public void start() {
        System.out.println("-- BIENVENUE DANS KIRBY ADVENTURE (TERMINAL) --");

        while (player.isAlive()) {
            System.out.println("\n--- MONDE " + worldLevel + " ---");
            Monster enemy = MonsterFactory.createRandomMonster();
            String abilityName = enemy.getAbility() != null ? enemy.getAbility().getName() : "Aucun";
            System.out.println("Un " + enemy.getName() + " apparait ! Il possede le pouvoir : " + abilityName);

            handleEncounter(enemy);

            if (player.isAlive()) {
                worldLevel++;
                System.out.println("Felicitations ! Vous passez au monde suivant.");
            }
        }

        System.out.println("Game Over... Kirby a succombe. Score : Monde " + worldLevel);
    }

    private void handleEncounter(Monster enemy) {
        System.out.println("Que voulez-vous faire ? (1) Attaquer | (2) Aspirer");
        String choice = scanner.nextLine();

        if ("2".equals(choice)) {
            if (enemy.getAbility() != null) {
                player.setPower(enemy.getAbility());
                System.out.println("Kirby a aspire le " + enemy.getName() + " !");
            } else {
                System.out.println("Ce monstre n'a aucun pouvoir a aspirer.");
            }
        } else {
            battle(enemy);
        }
    }

    private void battle(Monster enemy) {
        System.out.println("LE COMBAT COMMENCE CONTRE " + enemy.getName().toUpperCase());

        while (enemy.isAlive() && player.isAlive()) {
            System.out.println("\n[PV Kirby: " + player.getHp() + "] | [PV Ennemi: " + enemy.getHp() + "]");
            System.out.println("Actions : (1) Coup de pied | (2) Pouvoir Special | (3) Potion");
            String action = scanner.nextLine();

            switch (action) {
                case "1" -> player.basicAttack(enemy);
                case "2" -> player.useSpecialPower(enemy);
                case "3" -> player.heal();
                default -> System.out.println("Kirby rate son tour.");
            }

            if (!enemy.isAlive()) {
                System.out.println("Victoire ! L'ennemi est vaincu.");
                player.addGold(10);
                break;
            }

            enemy.basicAttack(player);
        }
    }

}
