package Core;

public abstract class Entity {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int damage;

    public Entity(String name, int maxHp, int damage) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.damage = damage;
    }

    public static void attack(Entity attacker, Entity target) {
        target.hp = Math.max(0, target.hp - attacker.damage);
        System.out.println(attacker.name + " attaque " + target.name + " et inflige " + attacker.damage + " degats. Il reste " + target.hp + " PV a " + target.name + ".");
    }

    public void basicAttack(Entity target) {
        attack(this, target);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public int takeDamage(int damage) {
        return this.hp -= damage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }
}
