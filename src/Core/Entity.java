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

    public static void attack(Entity attacker, Entity target) {
        int damage = 10;
        target.hp = Math.max(0, target.hp - damage);
        System.out.println(attacker.name + " attaque " + target.name + " et inflige " + damage + " degats. Il reste " + target.hp + " PV a " + target.name + ".");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }
}
