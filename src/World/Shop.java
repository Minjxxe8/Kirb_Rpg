package World;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Item> items;

    public Shop() {
        this.items = new ArrayList<>();
        initializeItems();
    }

    private void initializeItems() {
        items.add(new Item("Potion de soin", 20, ItemType.HEAL, 20));
        items.add(new Item("Pouvoir", 30, ItemType.POWER, 1));
    }

    public void displayShop() {
        System.out.println("\n=== Boutique ===");
        System.out.println("Articles disponibles :");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.printf("%d. %s - %d pièces d'or (%s: +%d)\n",
                    i + 1, item.getName(), item.getPrice(), item.getType(), item.getValue());
        }
        System.out.println("================\n");
    }

    public List<Item> getItems() {
        return items;
    }
}
