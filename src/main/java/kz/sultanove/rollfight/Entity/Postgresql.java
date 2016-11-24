package kz.sultanove.rollfight.Entity;

/**
 * Created by e.sultanov on 24.11.2016.
 */
public class Postgresql {
    public String getSelectCharacter() {
        return selectCharacter;
    }

    final private String selectCharacter = "select \"Character\".id,  \"Character\".name ,experience,level,strength,agility,constitution,intelligence,willpower,perseption,background ,alignment ,ability ,spell ,movement , \"Weapon\".name\n" +
            "from \"Character\" JOIN \"Weapon\" ON \"Character\".weapon_id = \"Weapon\".id;";

    public String getSelectWeapon() {
        return selectWeapon;
    }

    public String getSelectSpell() {
        return selectSpell;
    }

    final private String selectWeapon = "select * from \"Weapon\"";
    final private String selectSpell = "select * from \"Spell\"";
}
