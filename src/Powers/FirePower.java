package Powers;

import Core.Monster;

public class FirePower extends AbstractPower {


    @Override
    public String getName() {
        return "Fire";
    }

    @Override
    public int getDamage() {
        return 25;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.FIRE;
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return PowersEnum.ICE;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.STONE;
    }
}
