package com.company.common.skills.attack.skills;

import com.company.common.skills.Skill;
import com.company.common.skills.SkillFactory;

/**
 * Created by Loky on 14/07/2018.
 */
public enum AttackSkill {

    RAPID_STRIKE( SkillFactory.getSkill( "rapidStrike" ));

    private Skill skill;

    AttackSkill(Skill skill) {
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }
}
