package kz.sultanove.rollfight.Entity;

/**
 * Created by e.sultanov on 16.11.2016.
 */
public class Armor {
    Integer id;
    String armorType;
    String armorDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public String getArmorDescription() {
        return armorDescription;
    }

    public void setArmorDescription(String armorDescription) {
        this.armorDescription = armorDescription;
    }
}
