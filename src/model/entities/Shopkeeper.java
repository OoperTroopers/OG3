package model.entities;

import view.modelview.tileable.entities.ShopkeeperView;
import model.inventory.Shop;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.occupations.Occupation;
import model.statistics.Statistics;


public class Shopkeeper extends NPC {
	// constructor for Shopkeeper
	public Shopkeeper(Tile tile) {
		super(tile, new ShopkeeperView());
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
		int bargainingSkillLevel = avatar.getBargainingAbilityLevel();
		int avatarGold = avatar.getCurrentGold();
		
		Shop shop = new Shop(avatarInventory, shopkeeperInventory, bargainingSkillLevel, avatarGold);
		
		//runs infinitely until told to close. Returns the new value of the players gold.
		int change = shop.openShop();
		avatar.setGold(change);
	}	
	
	public String toString() {
		return "Entity=Shopkeeper";
	}
}
