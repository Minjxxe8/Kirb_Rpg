package Powers;

import Core.Monster;

public class IcePower implements Power {


    @Override
    public String getName() {
        return "Ice";
    }

    @Override
    public int getDamage() {
        return 25;
    }

    @Override
    public void executeAction(Monster target) {
        target.takeDamage(getDamage());
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.ICE;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return Power.super.getWeakAgainst();
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return Power.super.getStrongAgainst();
    }
}
