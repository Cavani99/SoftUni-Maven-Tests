package rpg_lab;

import org.example.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DummyTest {

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int ATK_DMG = 5;
    private Dummy dummy;

    @Before
    public void initializeTestObjects(){
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void dummyLosesHealth(){
        this.dummy.takeAttack(ATK_DMG);

        Assertions.assertEquals(ATK_DMG, this.dummy.getHealth());
    }

    @Test
    public void deadDummyException(){
        Assertions.assertThrows(IllegalStateException.class, () -> { // Assert
            this.dummy.takeAttack(ATK_DMG);
            this.dummy.takeAttack(ATK_DMG);
            this.dummy.takeAttack(ATK_DMG);
        });

    }

    @Test
    public void deadDummyGivesXP(){
        this.dummy.takeAttack(ATK_DMG);
        this.dummy.takeAttack(ATK_DMG);

        Assert.assertEquals(DUMMY_XP, dummy.giveExperience());
    }

    @Test
    public void aliveDummyCantGiveXP(){
        Assert.assertThrows(IllegalStateException.class, () -> { // Assert
            this.dummy.takeAttack(ATK_DMG);
        });
    }
}
