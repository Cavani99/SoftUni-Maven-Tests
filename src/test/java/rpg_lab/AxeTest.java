package rpg_lab;

import org.example.Axe;
import org.example.Dummy;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects(){
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void weaponAttacksLosesDurability(){
        this.axe.attack(this.dummy);

        Assertions.assertEquals(EXPECTED_DURABILITY,
                this.axe.getDurabilityPoints(),
                "Wrong durability, ");
    }

    @Test
    public void brokenWeaponCantAttack(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.axe.attack(this.dummy);
            this.axe.attack(this.dummy);
        });
    }
}
