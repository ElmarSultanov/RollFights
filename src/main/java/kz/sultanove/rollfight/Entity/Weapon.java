package kz.sultanove.rollfight.Entity;

/**
 * Created by e.sultanov on 16.11.2016.
 */
public class Weapon {
    Integer id;
    String weaponType;
    String weaponDamageType;
    Integer weaponDamage;
    String name;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(Integer weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public String getWeaponDamageType() {
        return weaponDamageType;
    }

    public void setWeaponDamageType(String weaponDamageType) {
        this.weaponDamageType = weaponDamageType;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
