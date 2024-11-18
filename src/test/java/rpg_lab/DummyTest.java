package rpg_lab;

import org.example.Axe;
import org.example.Dummy;
import org.junit.Assert;
import org.junit.Test;

public class DummyTest {


    @Test
    public void dummyLosesHealth(){
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(3);

        Assert.assertEquals(7, dummy.getHealth());
    }

    @Test
    public void deadDummyException(){
        Assert.assertThrows(IllegalStateException.class, () -> { // Assert
            Dummy dummy = new Dummy(10, 10);
            // Act

            dummy.takeAttack(10);
            dummy.takeAttack(1);
        });

    }

    @Test
    public void deadDummyGivesXP(){
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(10);

        Assert.assertEquals(10, dummy.giveExperience());
    }

    @Test
    public void aliveDummyCantGiveXP(){
        Assert.assertThrows(IllegalStateException.class, () -> { // Assert
            Dummy dummy = new Dummy(10, 10);
            // Act

            dummy.takeAttack(7);
            dummy.giveExperience();
        });
    }
}
