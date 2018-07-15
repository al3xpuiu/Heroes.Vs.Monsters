package com.company.common.skills;

import com.company.heroes.Fighter;


/**
 * Created by Loky on 13/07/2018.
 */
public class SkillFactory {

    public static Skill getSkill(String name) {
        switch (name) {
            case "rapidStrike" :
                return new Skill(10) {
                    @Override
                    public int useAbility(Fighter attacker, Fighter defender, int dmg) {
                        if (((int) (Math.random()*100) + 1) <= chance) {
                            System.out.println(attacker + " is to fast! He gets a free attack!");
                            attacker.attack( defender );
                            return 1;
                        }
                        return -1;
                    }
                };
            case "magicShield" :
                return new Skill(20) {
                    @Override
                    public int useAbility(Fighter attacker, Fighter defender, int dmg) {
                        if (((int) (Math.random()*100) + 1) <= chance) {
                            System.out.println(defender + " is using his magic shield! He mitigated half of the damage!");
                            return dmg/2;
                        }
                        return -1;
                    }
                };
            default: throw new UnsupportedOperationException( "There is no skill with the name " + name );
        }

    }
}
