package Core;

public class Boss extends Entity {
    private AttackStrategy strategy;

    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public int attack() {
        return strategy.executeAttack();
    }

    public Boss(String name) {
        super(name, 200, 30);
        this.strategy = new HeavyAttack();
    }

}
