package Powers;

import Core.Entity;

public class EnhancedPower extends PowerDecorator {

    private static final int DAMAGE_BONUS = 10;
    private final int level;

    public EnhancedPower(Power wrapped) {
        super(wrapped instanceof EnhancedPower ep ? ep : wrapped);
        this.level = wrapped instanceof EnhancedPower ep ? ep.level + 1 : 2;
    }

    @Override
    public String getName() {
        return wrapped.getName() + " (Niv." + level + ")";
    }

    @Override
    public int getDamage() {
        return wrapped.getDamage() + DAMAGE_BONUS;
    }

    @Override
    public void executeAction(Entity target) {
        System.out.println("Pouvoir amélioré Niv." + level + " ! (+" + ((level - 1) * DAMAGE_BONUS) + " dégâts bonus)");
        super.executeAction(target);
    }
}