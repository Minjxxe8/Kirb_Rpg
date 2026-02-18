package Powers;

public class PowerFactory {
    public static Power from(PowersEnum type) {
        if (type == null) return null;
        return switch (type) {
            case FIRE   -> new FirePower();
            case ICE    -> new IcePower();
            case SWORD  -> new SwordPower();
            case CUTTER -> new CutterPower();
            case BOMB   -> new BombPower();
            case STONE  -> new StonePower();
            case SPEAR  -> new SpearPower();
            case WHEEL  -> new WheelPower();
            case ARCHER -> new ArcherPower();
            case NINJA  -> new NinjaPower();
        };
    }
}