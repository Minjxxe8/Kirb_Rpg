import Core.Monster;
import Powers.FirePower;

void main() {
   System.out.println("Initialisation du projet");

   FirePower firePower = new FirePower();
   Monster monsterIce = new Monster("Ice Monster");
   firePower.executeAction(monsterIce);
}
