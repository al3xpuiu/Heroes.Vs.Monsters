package com.company.heroes;

import com.company.common.skills.Skill;
import com.company.common.skills.attack.skills.AttackSkill;
import com.company.common.skills.defence.skills.DefenceSkill;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Loky on 13/07/2018.
 */
public abstract class Fighter {

    private String name;
    private int health;
    private int strength;
    private int defence;
    private int speed;
    private int luck;

    private Range healthRange;
    private Range strengthRange;
    private Range defenceRange;
    private Range speedRange;
    private Range luckRange;

    public Fighter(String name, Range health, Range strength, Range defence, Range speed, Range luck) {

        this.healthRange = health;
        this.strengthRange = strength;
        this.defenceRange = defence;
        this.speedRange = speed;
        this.luckRange = luck;

        this.name = name;
        this.health = (int) (Math.random()*((health.getMax() - health.getMin()) + 1) + health.getMin());
        this.strength = (int) (Math.random()*((strength.getMax() - strength.getMin()) + 1) + strength.getMin());
        this.defence = (int) (Math.random()*((defence.getMax() - defence.getMin()) + 1) + defence.getMin());
        this.speed = (int) (Math.random()*((speed.getMax() - speed.getMin()) + 1) + speed.getMin());
        this.luck = (int) (Math.random()*((luck.getMax() - luck.getMin()) + 1) + luck.getMin());
    }

    public void attack(Fighter defender)  {

        try {
            System.out.println( this + " attacks! " );

            Thread.sleep( 3000 );

            int dmg = this.getStrength() - defender.getDefence();

            if (((int) (Math.random() * 100) + 1) <= defender.getLuck()) {
                System.out.println( defender + " got lucky! No dmg!" );
                return;
            }

            if (defender instanceof Hero) {
                Hero hero = (Hero) defender;
                for (DefenceSkill s : hero.getDefenceSkills()) {
                    int dmgReduction = s.getSkill().useAbility( this, defender, dmg );
                    if (dmgReduction > 0) {
                        Thread.sleep( 2000 );
                        dmg = dmg - dmgReduction;
                    }
                }
            }

            if (this instanceof Hero) {
                Hero hero = (Hero) this;
                for (AttackSkill s : hero.getAttackSkills()) {
                    s.getSkill().useAbility( this, defender, dmg );
                    Thread.sleep( 2000 );
                }
            }

            System.out.println( "It does " + dmg + " damage!" );
            defender.setHealth( defender.getHealth() - dmg );

            Thread.sleep( 3000 );

            if (defender.getHealth() > 0) {
                System.out.println( defender + " has " + defender.getHealth() + " health left!" );
            } else {
                System.out.println();
                System.out.println(defender + " died in glorious battle!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Arrays.asList(name.split("_")).stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase())
                .collect( Collectors.joining(" "));
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public static class Range {
        private int min;
        private int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Range getHealthRange() {
        return healthRange;
    }

    public Range getStrengthRange() {
        return strengthRange;
    }

    public Range getDefenceRange() {
        return defenceRange;
    }

    public Range getSpeedRange() {
        return speedRange;
    }

    public Range getLuckRange() {
        return luckRange;
    }
}
