package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Staff;
import model.inventory.Inventory;

public class SummonerEquipmentManager extends EquipmentManager {
	private Staff staff;

	public SummonerEquipmentManager() {
		super();
		this.staff = null;
	}
	
	public SummonerEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, Staff staff) {
		super(helmet, chest, arms, legs);
		this.staff = staff;
	}
	
	public void equipStaff(Staff staff) {
		this.staff = staff;
	}
	
	public void unequipStaff(Inventory inventory) {
		inventory.addToInventory(staff);
		staff= null;
	}
	
	public Staff getStaff() {
		return staff;
	}
}
