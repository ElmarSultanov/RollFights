package kz.sultanove.rollfight;

/**
 * Created by e.sultanov on 16.11.2016.
 */
public class Spell {
    Integer id;
    byte spellLevel;
    String spellSchool;
    String spellDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(byte spellLevel) {
        this.spellLevel = spellLevel;
    }

    public String getSpellSchool() {
        return spellSchool;
    }

    public void setSpellSchool(String spellSchool) {
        this.spellSchool = spellSchool;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public void setSpellDescription(String spellDescription) {
        this.spellDescription = spellDescription;
    }
}
