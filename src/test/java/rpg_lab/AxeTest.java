package rpg_lab;

import org.example.Axe;
import org.example.Dummy;
import org.junit.Assert;
import org.junit.Test;

public class AxeTest {

    @Test
    public void weaponAttacksLosesDurability(){
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);

        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test
    public void brokenWeaponCantAttack(){
        Assert.assertThrows(IllegalStateException.class, () -> { // Assert
            // Arrange
            Axe axe = new Axe(10, 1);
            Dummy dummy = new Dummy(10, 10);
            // Act
            axe.attack(dummy);
            axe.attack(dummy);
        });
    }
}
