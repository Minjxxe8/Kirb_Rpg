package Powers;

public class ArcherPower extends AbstractPower{
    @Override
    public String getName() {
        return "Archer";
    }

    @Override
    public int getDamage() {
        return 27;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.ARCHER;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.NINJA;
    }

    @Override
    public PowersEnum getStrongAgainst() {
        return PowersEnum.SWORD;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.CUTTER;
    }
}
