package kz.sultanove.rollfight;

/**
 * Created by e.sultanov on 16.11.2016.
 */
public class Spell {
    private Integer id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int spellLevel;
    private String spellSchool;
    private String spellDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
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

    public String getName() {
        return name;
    }
}
