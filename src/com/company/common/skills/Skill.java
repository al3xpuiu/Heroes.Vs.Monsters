package com.company.common.skills;

import com.company.heroes.Fighter;

import java.util.List;

/**
 * Created by Loky on 13/07/2018.
 */
public abstract class Skill {
    double chance;

    Skill(double chance) {
        this.chance = chance;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    abstract public int useAbility(Fighter attacker, Fighter defender, int dmg);

}
