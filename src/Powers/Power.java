package Powers;

import Core.Monster;

public interface Power {
    String getName();
    int getDamage();
    void executeAction(Monster target);
    PowersEnum getType();

    default PowersEnum getWeakAgainst() { return null; }
    default PowersEnum getStrongAgainst() { return null; }
}
