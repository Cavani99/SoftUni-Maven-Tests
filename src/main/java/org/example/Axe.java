package org.example;

public class Axe implements Weapon{

    private int attackPoints;
    private int durabilityPoints;

    public Axe(int attack, int durability) {
        this.attackPoints = attack;
        this.durabilityPoints = durability;
    }

    @Override
    public void attack(Target target) {
        if(this.durabilityPoints <= 0){
            throw new IllegalStateException("Axe is broken.");
        }
        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public int getDurabilityPoints() {
        return this.durabilityPoints;
    }

    public void attack(Dummy target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("Axe is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }
}
