package com.company.common.skills.defence.skills;

import com.company.common.skills.Skill;
import com.company.common.skills.SkillFactory;

/**
 * Created by Loky on 14/07/2018.
 */
public enum DefenceSkill {

    MAGIC_SHIELD( SkillFactory.getSkill( "magicShield" ));

    private Skill skill;

    DefenceSkill(Skill skill) {
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }
}
