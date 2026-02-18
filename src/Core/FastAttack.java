package Core;

public class FastAttack implements AttackStrategy {
    @Override
    public int executeAttack() {
        System.out.println("Le boss utilise combo rapide !");
        return 10;
    }
}
