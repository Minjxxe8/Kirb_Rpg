package World;

import Core.Kirby;
import Powers.Power;
import Powers.PowerFactory;
import Powers.PowersEnum;

import java.util.ArrayList;
import java.util.Collections;
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
        items.add(new Item("Potion de soin", 20, ItemType.HEAL, 40));

        PowersEnum[] powers = PowersEnum.values();
        List<PowersEnum> shuffled = new ArrayList<>(List.of(powers));
        Collections.shuffle(shuffled);

        for (int i = 0; i < 2; i++) {
            PowersEnum power = shuffled.get(i);
            Power p = PowerFactory.from(power);
            items.add(new Item(p.getName(), 50, ItemType.POWER, power.ordinal()));
        }
    }

    public void displayShop(Kirby kirby) {
        System.out.println("\n=== Boutique ===");
        System.out.println("Or disponible : " + kirby.getInventory().getGold());
        System.out.println("\nArticles disponibles :");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.printf("%d. %s - %d pièces d'or (%s)\n",
                    i + 1, item.getName(), item.getPrice(), item.getType());
        }
        System.out.println("================\n");

        boolean shopping = true;
        while (shopping) {
            System.out.print("Choisissez un article (0 pour quitter) : ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice == 0) {
                    shopping = false;
                    System.out.println("Merci de votre visite !");
                } else if (choice >= 1 && choice <= items.size()) {
                    purchaseItem(kirby, items.get(choice - 1));
                } else {
                    System.out.println("Choix invalide !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide !");
            }
        }
    }


    private void purchaseItem(Kirby player, Item item) {
        if (player.getInventory().getGold() < item.getPrice()) {
            System.out.println("Pas assez d'or ! (Requis : " + item.getPrice() + ", Disponible : " + player.getInventory().getGold() + ")");
            return;
        }

        if (player.getInventory().spendGold(item.getPrice())) {
            if (item.getType() == ItemType.HEAL) {
                player.addPotions(1);
                System.out.println("✓ Potion achetée ! (+1 potion dans l'inventaire)");
            } else if (item.getType() == ItemType.POWER) {
                PowersEnum powerType = PowersEnum.values()[item.getValue()];
                player.buyPower(powerType);
            }
            System.out.println("Or restant : " + player.getInventory().getGold());
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
