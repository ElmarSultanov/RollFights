package kz.sultanove.rollfight;

/**
 * Created by e.sultanov on 16.11.2016.
 */
public class Weapon {
    Integer id;
    String weaponType;
    String weaponDamageType;
    Integer weaponDamage;

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
