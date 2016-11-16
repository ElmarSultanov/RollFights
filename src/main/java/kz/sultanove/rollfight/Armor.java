package kz.sultanove.rollfight;

/**
 * Created by e.sultanov on 16.11.2016.
 */
public class Armor {
    Integer id;
    byte armorType;
    String armorDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte getArmorType() {
        return armorType;
    }

    public void setArmorType(byte armorType) {
        this.armorType = armorType;
    }

    public String getArmorDescription() {
        return armorDescription;
    }

    public void setArmorDescription(String armorDescription) {
        this.armorDescription = armorDescription;
    }
}
