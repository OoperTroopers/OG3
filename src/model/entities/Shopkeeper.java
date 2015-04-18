package model.entities;

import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.occupations.Occupation;
import model.statistics.Statistics;


public class Shopkeeper extends NPC {
	// constructor for Shopkeeper
	public Shopkeeper() {
		super();
	}
	
	public Shopkeeper(Occupation o, EquipmentManager em, Statistics s) {
		super(o, em, s, false);
	}
	
	public void dialgue() {
		System.out.println("I am a shopkeeping god. Fear me.");
	}
	
	public void openShop(Avatar avatar) {
		Inventory avatarInventory = avatar.getInventory();
		Inventory shopkeeperInventory = this.getInventory();
		//int bargainingSkillLevel = avatar.getSkillLevel(bargaining)
		//int avatarGold = avatar.getCurrentGold();
		//Shop handles all of the transaction stuff
		//Shop shop = new Shop(avatarInventory, shopkeeperInventory, bargainingSkillLevel, avatarGold);
		//int change = shop.open();
		//avatar.setGold(change);
	}	
}
