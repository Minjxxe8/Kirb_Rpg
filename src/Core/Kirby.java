package Core;
import Powers.Power;

class Kirby {
    private Power state;
    private final int MAX_HP = 100;
    private int hp = MAX_HP;
    private static int enemiesDefeated = 0;

    public static int getEnemiesDefeated() {
        return enemiesDefeated;
    }

    public static void setEnemiesDefeated(int enemiesDefeated) {
        Kirby.enemiesDefeated = enemiesDefeated;
    }

    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
        System.out.println("Kirby a reçu " + damage + " dégâts !");
        displayHealthBar();
    }

    public void displayHealthBar() {
        int barLength = 20;
        double healthRatio = (double) hp / MAX_HP;
        int filledMarkers = (int) (healthRatio * barLength);

        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < filledMarkers) bar.append("=");
            else bar.append(" ");
        }
        bar.append("] " + hp + "/" + MAX_HP + " PV");

        System.out.println(bar.toString());
        if (hp <= 0) System.out.println("GAME OVER : Kirby est K.O. !");
    }
}
