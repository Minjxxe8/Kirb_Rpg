package Core;

abstract class Entity {
    protected String name;
    protected int hp;
    protected int maxHp;

    public Entity(String name, int maxHp) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
        System.out.println(name + " reçoit " + damage + " dégâts !");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    public abstract void doAction();
}
