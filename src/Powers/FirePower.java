package Powers;

import Core.Monster;

public class FirePower implements Power {


    @Override
    public String getName() {
        return "Fire";
    }

    @Override
    public int getDamage() {
        return 35;
    }

    @Override
    public void executeAction(Monster target) {
        target.takeDamage(getDamage());
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.FIRE;
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return PowersEnum.ICE;
    }
}
