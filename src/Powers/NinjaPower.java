package Powers;

public class NinjaPower extends AbstractPower{
    @Override
    public String getName() {
        return "Ninja";
    }

    @Override
    public int getDamage() {
        return 36;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.NINJA;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.SWORD;
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return PowersEnum.ARCHER;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.FIRE;
    }
}
