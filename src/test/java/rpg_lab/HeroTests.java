package rpg_lab;

import org.example.Hero;
import org.example.Target;
import org.example.Weapon;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class HeroTests {

    @Test
    public void attackGainsXPIfTargetIsDead(){
        Target fakeTarget = new Target() {
            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public int giveExperience() {
                return 10;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };

        Hero hero = new Hero("Roger", fakeWeapon);
        hero.attack(fakeTarget);
        Assertions.assertEquals(10, hero.getExperience(), "Wrong experience");
    }

}
