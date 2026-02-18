package Powers;

public class CutterPower extends AbstractPower {
    @Override
    public String getName() {
        return "Cutter";
    }

    @Override
    public int getDamage() {
        return 35;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.CUTTER;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.ARCHER;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.SPEAR;
    }
}
