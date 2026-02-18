package Powers;

import Core.Entity;

public interface Power {
    String getName();
    int getDamage();
    void executeAction(Entity target);
    PowersEnum getType();

    default PowersEnum getWeakAgainst() { return null; }
    default PowersEnum getStrongAgainst() { return null; }
    default PowersEnum getBetterAgainst() { return null; }

}
