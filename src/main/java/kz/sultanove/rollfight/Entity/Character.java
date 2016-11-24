package kz.sultanove.rollfight.Entity;

/**
 * Created by e.sultanov on 16.11.2016.
 id integer,
 name text,
 experience integer,
 level integer,
 strength integer,
 agility integer,
 constitution integer,
 intelligence integer,
 willpower integer,
 perseption integer,
 background text,
 alignment text,
 ability text,
 spell text,
 movement text
 */

public class Character {
    Integer id;
    String characterName;
    Integer expPoint;
    Integer characterLevel;
    Integer strength;
    Integer agility;
    Integer constitution;
    Integer intelligence;
    Integer willpower;
    Integer perseption;
    String alignment;
    String spell;

    public String getWeaponName_byId() {
        return weaponName_byId;
    }

    public void setWeaponName_byId(String weaponName_byId) {
        this.weaponName_byId = weaponName_byId;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    String weaponName_byId;

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    String ability;
    String movement;

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

    public Integer getExpPoint() {
        return expPoint;
    }

    public void setExpPoint(Integer expPoint) {
        this.expPoint = expPoint;
    }

    public Integer getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(Integer characterLevel) {
        this.characterLevel = characterLevel;
    }

    public Integer getStrenght() {
        return strength;
    }

    public void setStrenght(Integer strength) {
        this.strength = strength;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getIntellegence() {
        return intelligence;
    }

    public void setIntellegence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWillpower() {
        return willpower;
    }

    public void setWillpower(Integer willpower) {
        this.willpower = willpower;
    }

    public Integer getPerseption() {
        return perseption;
    }

    public void setPerseption(Integer perseption) {
        this.perseption = perseption;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }
}
