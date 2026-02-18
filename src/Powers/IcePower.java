package Powers;

import Core.Monster;

public class IcePower extends AbstractPower {


    @Override
    public String getName() {
        return "Ice";
    }

    @Override
    public int getDamage() {
        return 20;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.ICE;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.FIRE;
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return PowersEnum.STONE;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.CUTTER;
    }
}
