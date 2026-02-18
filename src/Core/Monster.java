package Core;
import Powers.Power;
import Powers.PowersEnum;

public class Monster extends Entity {
    private PowersEnum powersEnum;
    private Power currentPower;

    public Monster(String name) {
        super(name, 80, 10);
    }

    public PowersEnum getPower() {
        return PowersEnum.FIRE;
    }

    public Power getAbility() {
        return this.currentPower;
    }

}
