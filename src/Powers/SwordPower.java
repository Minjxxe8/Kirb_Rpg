package Powers;

public class SwordPower extends AbstractPower{
    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public int getDamage() {
        return 30;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.SWORD;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.NINJA;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.ARCHER;
    }
}
