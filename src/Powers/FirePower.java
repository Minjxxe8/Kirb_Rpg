package Powers;

import Core.Monster;

public class FirePower implements Power {

    public Monster monster;

    @Override
    public String getName() {
        return "Fire";
    }

    @Override
    public int getDamage() {
        return 35;
    }

    @Override
    public void executeAction() {
        int damage = getDamage();

        if (target.getPower() == PowersEnum.ICE){
            System.out.println("Tu l'a brulé, il est mort sur le coup");
            target.setHp(0);
        } else if (target.getPower() == PowersEnum.FIRE) {
            System.out.println("Ton pouvoir est inneficace contre ce mob, tu lui inflige des dégats classiques");
            target.takeDamage(20);
        } else {
            System.out.println("Tu inflige " + damage + " degats a " + target.getName() + ". Il lui reste " + target.getHp() + " PV.");
        }
    }
}
