package Core;

import Powers.Power;

public class Kirby extends Entity {
    private static final int MAX_HP = 100;
    private final Inventory inventory;
    private Power currentPower;

    public Kirby() {
        super("Kirby", MAX_HP, 20);
        this.inventory = new Inventory(3, 0);
    }

    public void setPower(Power power) {
        this.currentPower = power;
    }

    public void useSpecialPower(Entity target) {
        if (currentPower == null) {
            System.out.println("Aucun pouvoir special equipe.");
            return;
        }

        currentPower.executeAction();
        attack(this, target);
    }

    public void heal() {
        if (inventory.usePotion()) {
            this.hp = Math.min(maxHp, hp + 40);
            System.out.println("Kirby utilise une potion. PV: " + hp + ". Potions restantes: " + inventory.getPotionCount());
        } else {
            System.out.println("Plus de potions !");
        }
    }

    public void addGold(int amount) {
        inventory.addGold(amount);
    }

    public void addPotions(int amount) {
        inventory.addPotions(amount);
    }

    public void showInventory() {
        System.out.println("Inventaire -> Potions: " + inventory.getPotionCount() + " | Or: " + inventory.getGold());
    }

    public void displayHealthBar() {
        int barLength = 20;
        double healthRatio = (double) hp / maxHp;
        int filledMarkers = (int) (healthRatio * barLength);

        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < filledMarkers) {
                bar.append("=");
            } else {
                bar.append(" ");
            }
        }
        bar.append("] " + hp + "/" + maxHp + " PV");

        System.out.println(bar);
        if (hp <= 0) {
            System.out.println("GAME OVER : Kirby est K.O. !");
        }
    }
}
