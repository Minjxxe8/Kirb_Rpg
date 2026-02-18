package Core;
import Powers.PowersEnum;

public class Monster extends Entity {
    private PowersEnum powersEnum;

    public Monster(String name) {
        super(name, 80, 10);
    }

    public PowersEnum getPower() {
        return PowersEnum.FIRE;
    }
}
