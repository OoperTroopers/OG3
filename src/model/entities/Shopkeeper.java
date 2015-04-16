package model.entities;

import java.util.ArrayList;

import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.occupations.Occupation;
import model.statistics.Statistics;
import model.items.TakeableItem;


public class Shopkeeper extends NPC {
	// constructor for Shopkeeper
	public Shopkeeper(Occupation o, EquipmentManager em, Statistics s) {
		super(o, em, s, false);
	}
	
	public void dialgue() {
		System.out.println("I am a shopkeeping god. Fear me.");
	}
	
	public void openShop(Avatar avatar) {
		Inventory avatarInventory = avatar.getInventory();
		Inventory shopkeeperInventory = this.getInventory();
		//send to view to display everything
	}
	
	//adjusted buy price means lower than base. Shopkeeper's perspective
	private int adjustedBuyPrice(TakeableItem item) {
		//do calculation based on bargaining skill level
		return item.getValue();
	}
	
	//adjusted sell price means higher than base. Shopkeeper's perspective.
	private int adjustedSellPrice(TakeableItem item) {
		//do calculation based on bargaining skill level
		return item.getValue();
	}
	
	//buying is from shopkeepers perspective. The player is selling.
	public void buyItem(TakeableItem item) {
		int buyPrice = adjustedBuyPrice(item);
		System.out.println(buyPrice);
	}

	//selling is from shopkeepers perspective. The player is buying.
	public void sellItem(TakeableItem item) {
		int sellPrice = adjustedSellPrice(item);
		System.out.println(sellPrice);
	}
	
}
