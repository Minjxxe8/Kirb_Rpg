package Powers;

public class SpearPower extends AbstractPower{
    @Override
    public String getName() {
        return "Spear";
    }

    @Override
    public int getDamage() {
        return 27;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.SPEAR;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.CUTTER;
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return PowersEnum.BOMB;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.SWORD;
    }
}
