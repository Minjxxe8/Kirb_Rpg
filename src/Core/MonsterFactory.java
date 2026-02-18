package Core;

import java.util.Random;

public class MonsterFactory {
    private static final String[] NAMES = {"Waddle Dee", "Waddle Doo", "Bronto Burt"};
    private static final Random RANDOM = new Random();

    private MonsterFactory() {
    }

    public static Monster createRandomMonster() {
        return new Monster(NAMES[RANDOM.nextInt(NAMES.length)]);
    }
}
