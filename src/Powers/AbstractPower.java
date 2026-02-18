package Powers;

import Core.Monster;

public abstract class AbstractPower implements Power {

    @Override
    public void executeAction(Monster target) {

        if (target.getPower() == getStrongAgainst()) {
            System.out.println("Super efficace ! " + target.getName() + " est vaincu d'un coup !");
            target.setHp(0);

        } else if (target.getPower() == getWeakAgainst()) {

            int reducedDamage = getDamage() / 2;
            System.out.println("Pas très efficace... Tu infligeas seulement " + reducedDamage + " dégâts à " + target.getName() + ".");
            target.takeDamage(reducedDamage);

        } else if (target.getPower() == getBetterAgainst()) {

            int increasedDamage = (int) (getDamage() * 1.5);
            System.out.println("Efficace ! Tu infliges " + getDamage() + " dégâts à " + target.getName() + ".");
            target.takeDamage(increasedDamage);

        } else if (target.getPower() == getType()) {

            System.out.println("Même pouvoir ! Tu lui infliges des dégâts classiques.");
            target.takeDamage(20);

        } else {
            target.takeDamage(getDamage());
            System.out.println("Tu infliges " + getDamage() + " dégâts à " + target.getName() + ".");
        }
    }
}
