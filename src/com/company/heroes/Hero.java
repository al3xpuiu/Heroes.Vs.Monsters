package com.company.heroes;

import com.company.common.skills.Skill;
import com.company.common.skills.attack.skills.AttackSkill;
import com.company.common.skills.defence.skills.DefenceSkill;
import org.w3c.dom.ranges.Range;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Loky on 13/07/2018.
 */
public class Hero extends Fighter {

    private List<AttackSkill> attackSkills;
    private List<DefenceSkill> defenceSkills;

    public Hero(String name, Fighter.Range health, Fighter.Range strength, Fighter.Range defence, Fighter.Range speed, Fighter.Range luck, List<AttackSkill> attackSkills, List<DefenceSkill> defenceSkills) {
        super( name, health, strength, defence, speed, luck );
        this.attackSkills = attackSkills;
        this.defenceSkills = defenceSkills;
    }


    public List<AttackSkill> getAttackSkills() {
        return attackSkills;
    }

    public List<DefenceSkill> getDefenceSkills() {
        return defenceSkills;
    }
}
