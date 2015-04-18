package model.statistics;

public class EquippableStatistics {
	private int damageValue;
	private int armorValue;
	
	public EquippableStatistics() {
		this.damageValue = 10;
		this.armorValue = 10;
	}
	
	public EquippableStatistics(int damageValue, int armorValue) {
		this.damageValue = damageValue;
		this.armorValue = armorValue;
	}

	public int getDamageValue() {
		return damageValue;
	}

	public void setDamageValue(int damageValue) {
		this.damageValue = damageValue;
	}

	public int getArmorValue() {
		return armorValue;
	}

	public void setArmorValue(int armorValue) {
		this.armorValue = armorValue;
	}
}
