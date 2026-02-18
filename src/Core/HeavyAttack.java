package Core;

public class HeavyAttack implements AttackStrategy {
    @Override
    public int executeAttack() {
        System.out.println("Le boss utilise écrasement !");
        return 30;
    }
}
