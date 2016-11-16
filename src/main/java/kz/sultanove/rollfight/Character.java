package kz.sultanove.rollfight;

/**
 * Created by e.sultanov on 16.11.2016.
 */
public class Character {
    Integer id;
    String characterName;
    String characterRole;
    Integer characterLevel;
    Weapon characterWeapon;
    Armor characterArmor;
    Spell characterSpell;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterRole() {
        return characterRole;
    }

    public void setCharacterRole(String characterRole) {
        this.characterRole = characterRole;
    }

    public Integer getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(Integer characterLevel) {
        this.characterLevel = characterLevel;
    }

    public Weapon getCharacterWeapon() {
        return characterWeapon;
    }

    public void setCharacterWeapon(Weapon characterWeapon) {
        this.characterWeapon = characterWeapon;
    }

    public Armor getCharacterArmor() {
        return characterArmor;
    }

    public void setCharacterArmor(Armor characterArmor) {
        this.characterArmor = characterArmor;
    }

    public Spell getCharacterSpell() {
        return characterSpell;
    }

    public void setCharacterSpell(Spell characterSpell) {
        this.characterSpell = characterSpell;
    }
}
