package rpg_lab;

import org.example.Hero;
import org.example.Target;
import org.example.Weapon;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class HeroTests {

    @Test
    public void attackGainsXPIfTargetIsDead(){

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(10);

        Hero hero = new Hero("Roger", weaponMock);
        hero.attack(targetMock);

        Assertions.assertEquals(10, hero.getExperience(), "Wrong experience");
    }

}
