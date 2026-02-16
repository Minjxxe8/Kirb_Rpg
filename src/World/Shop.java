package World;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Shop {
    private List<Item> items;
    private Scanner scanner;

    public Shop() {
        this.items = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeItems();
    }
    private void initializeItems() {
        items.add(new Item("Potion de soin", 20, ItemType.HEAL, 20));
        items.add(new Item("Pouvoir", 20, ItemType.POWER, 1));
    }
    public void openShop(Player player){
        System.out.println("\n=== Bienvenue à la boutique ! ===");
        System.out.println("Tu as " + player.getGold() + " pièces d'or.");
        System.out.println("Voici les articles disponibles :");

        boolean shooping = true;
        while (shooping) {
            displayItems();
            System.out.println("\n0. Quitter la boutique");
            System.out.print("Choisis un article à acheter (numéro): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                shopping = false;
                System.out.println("Merci de votre visite ! À bientôt !");
            }else if (choice > 0 && choice <= items.size()) {
                purchaseItem(player, items.get(choice - 1));
            }else{
                System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
    private void displayItems() {
        System.out.println("\nArticles disponibles :");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.printf("%d. %s - %d pièces d'or (%s: +%d)\n", i + 1, item.getName(), item.getPrice(), item.getType(), item.getValue());
        }
    }
    private void purchaseItem(Player player, Item item){
        switch (item.getType()){
            case HEAL:
                if (player.getGold() >= item.getPrice()) {
                    player.heal(item.getValue());
                    player.spendGold(item.getPrice());
                    System.out.println("Tu as acheté une " + item.getName() + " et tu as récupéré " + item.getValue() + " points de vie !");
                } else {
                    System.out.println("Tu n'as pas assez d'or pour acheter cet article.");
                }
                break;
            case POWER:
                if (player.getGold() >= item.getPrice()) {
                    player.upgradePower();
                    player.spendGold(item.getPrice());
                    System.out.println("Tu as acheté un " + item.getName() + " et tu as un nouveau pouvoir !");
                } else {
                    System.out.println("Tu n'as pas assez d'or pour acheter cet article.");
                }
                break;
             default:
                 System.out.println("Type d'article inconnu.");
        }
    }
}
