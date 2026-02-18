package Core;

import java.util.Random;

class EntityFactory {
    public static Entity spawnEnemy(int level) {
        if (level % 5 == 0) {
            return new Boss("Roi Dadidou");
        } else {
            String[] names = {"Waddle Dee", "Waddle Doo", "Meta Knight Minion"};
            return null;
            //return new Monster(names[new Random().nextInt(names.length)]);
        }
    }
}
