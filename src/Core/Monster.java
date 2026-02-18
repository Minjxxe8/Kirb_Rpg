package Core;
import Powers.Power;
import Powers.PowerFactory;
import Powers.PowersEnum;

public class Monster extends Entity {
    private PowersEnum powersEnum;
    private Power currentPower;

    public Monster(String name, PowersEnum power) {
        super(name, 80, 10);
        this.powersEnum = power;
        this.currentPower = PowerFactory.from(power);
    }

    @Override
    public PowersEnum getPower() { return powersEnum; }

    public Power getAbility() {
        return this.currentPower;
    }

}
