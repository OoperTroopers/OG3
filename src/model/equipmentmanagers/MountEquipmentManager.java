package model.equipmentmanagers;

import model.items.Arms;
import model.items.Chest;
import model.items.Helmet;
import model.items.Legs;
import model.items.Saddle;
import model.inventory.Inventory;

public class MountEquipmentManager extends EquipmentManager {
	private Saddle saddle;

	public MountEquipmentManager() {
		super();
		this.saddle = null;
	}
	
	public MountEquipmentManager(Helmet helmet, Chest chest, Arms arms, Legs legs, Saddle saddle) {
		super(helmet, chest, arms, legs);
		this.saddle = saddle;
	}
	
	public void equipSaddle(Saddle saddle) {
		this.saddle = saddle;
	}
	
	public void unequipSaddle(Inventory inventory) {
		inventory.addToInventory(saddle);
		saddle = null;
	}
	
	public Saddle getSaddle() {
		return saddle;
	}
}
