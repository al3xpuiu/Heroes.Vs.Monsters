package com.company.heroes;

import com.company.common.skills.attack.skills.AttackSkill;
import com.company.common.skills.defence.skills.DefenceSkill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loky on 13/07/2018.
 */
public class FighterFactory {
    public static Fighter getFigher(Fighters name) {
        switch (name) {
            case THE_KNIGHT:
                Fighter.Range orderusHealth = new Fighter.Range( 70, 100 );
                Fighter.Range orderusStrength = new Fighter.Range( 70, 80 );
                Fighter.Range orderusDefence = new Fighter.Range( 45, 55 );
                Fighter.Range orderusSpeed = new Fighter.Range( 40, 50 );
                Fighter.Range orderusLuck = new Fighter.Range( 10, 30 );

                List<AttackSkill> attackSkills = new ArrayList<>(  );
                attackSkills.add( AttackSkill.RAPID_STRIKE );

                List<DefenceSkill> defenceSkills = new ArrayList<>(  );
                defenceSkills.add( DefenceSkill.MAGIC_SHIELD );
                return new Hero( name.name(), orderusHealth, orderusStrength, orderusDefence, orderusSpeed, orderusLuck, attackSkills, defenceSkills );

            case THE_LONG_CLAWS:
                Fighter.Range forestMonsterHealth = new Fighter.Range( 60, 90 );
                Fighter.Range forestMonsterStrength = new Fighter.Range( 60, 90 );
                Fighter.Range forestMonsterDefence = new Fighter.Range( 40, 60 );
                Fighter.Range forestMonsterSpeed = new Fighter.Range( 40, 60 );
                Fighter.Range forestMonsterLuck = new Fighter.Range( 25, 40 );

                return new Monster( name.name(), forestMonsterHealth, forestMonsterStrength, forestMonsterDefence, forestMonsterSpeed, forestMonsterLuck );
            default: throw new UnsupportedOperationException( "There is no fighter with the name " + name );
        }
    }
}
