package Core;
import Powers.Power;

public class Monster extends Entity {
    private Power ability;

    public Monster(String name) {
        super(name, 80, 10);
    }

    public Power getAbility() {
        return ability;
    }
}
