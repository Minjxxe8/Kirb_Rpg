package Powers;

import Core.Monster;

public interface Power {
    String getName();
    int getDamage();
    void executeAction(Monster target);
}
