package Powers;

public class WheelPower extends AbstractPower{
    @Override
    public String getName() {
        return "Wheel";
    }

    @Override
    public int getDamage() {
        return 26;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.WHEEL;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.SPEAR;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.NINJA;
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return PowersEnum.STONE;
    }
}
