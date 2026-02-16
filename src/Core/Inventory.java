package Core;

public class Inventory {
    private int potionCount;
    private int gold;

    public Inventory(int potionCount, int gold) {
        this.potionCount = Math.max(0, potionCount);
        this.gold = Math.max(0, gold);
    }

    public int getPotionCount() {
        return potionCount;
    }

    public int getGold() {
        return gold;
    }

    public void addPotions(int amount) {
        if (amount > 0) {
            potionCount += amount;
        }
    }

    public boolean usePotion() {
        if (potionCount <= 0) {
            return false;
        }
        potionCount--;
        return true;
    }

    public void addGold(int amount) {
        if (amount > 0) {
            gold += amount;
        }
    }

    public boolean spendGold(int amount) {
        if (amount <= 0 || amount > gold) {
            return false;
        }
        gold -= amount;
        return true;
    }
}
