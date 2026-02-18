package Powers;

public class StonePower extends AbstractPower{
    @Override
    public String getName() {
        return "Stone";
    }

    @Override
    public int getDamage() {
        return 26;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.STONE;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.BOMB;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.SPEAR;
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return PowersEnum.FIRE;
    }
}
