package Core;

import Powers.Power;
import Powers.PowerFactory;
import Powers.PowersEnum;

import java.util.Random;

public class MonsterFactory {
    private static final Random RANDOM = new Random();

    private MonsterFactory() {}

    public static Monster createRandomMonster() {
        PowersEnum[] powers = PowersEnum.values();
        PowersEnum randomPower = powers[RANDOM.nextInt(powers.length)];
        Power power = PowerFactory.from(randomPower);
        return new Monster(power.getName(), randomPower);
    }
}