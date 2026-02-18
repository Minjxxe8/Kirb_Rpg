package Powers;

public class BombPower extends AbstractPower {
    @Override
    public String getName() {
        return "Bomb";
    }

    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public PowersEnum getType() {
        return PowersEnum.BOMB;
    }

    @Override
    public PowersEnum getWeakAgainst() {
        return PowersEnum.SPEAR;
    }

    @Override
    public PowersEnum getBetterAgainst() {
        return PowersEnum.STONE;
    }
}
