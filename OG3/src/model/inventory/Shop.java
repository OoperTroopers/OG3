package model.inventory;

import model.items.TakeableItem;

public class Shop {
	private Inventory avatarInventory;
	private Inventory shopkeeperInventory;
	private int bargainingSkillLevel;
	private int avatarGold;
	private boolean storeOpen;
	
	public Shop(Inventory avatarInventory, Inventory shopkeeperInventory, int bargainingSkillLevel, int avatarGold) {
		this.avatarInventory = avatarInventory;
		this.shopkeeperInventory = shopkeeperInventory;
		this.bargainingSkillLevel = bargainingSkillLevel;
		this.avatarGold = avatarGold;
		this.storeOpen = true;
	}

	public int openShop() {
		while(isOpenShop()) {
			//run view stuff infinitely
			//on close shop, method will be called to change storeOpen value to false
			//handled by controller
			storeOpen = false;
		}
		return avatarGold;
	}
	
	private boolean isOpenShop() {
		return storeOpen;
	}
	
	public void closeShop() {
		storeOpen = false;
	}
	
	//Method names from player's perspective
	public int adjustedBuyPrice(TakeableItem item) {
		int price = item.getValue();
		price = price + (int)(price * (1 - bargainingSkillLevel / 100.0));
		return price;
	}
	
	public int adjustedSellPrice(TakeableItem item) {
		int price = item.getValue();
		price = Math.max((int)(price * (bargainingSkillLevel / 100.0)), 1);
		return price;
	}
	
	public void buyItem(TakeableItem item) {
		int buyPrice = adjustedBuyPrice(item);
		if(buyPrice < avatarGold) {
			avatarGold -= buyPrice;
			avatarInventory.  addToInventory(item);
			shopkeeperInventory.removeFromInventory(item);
		}
	}

	public void sellItem(TakeableItem item) {
		int sellPrice = adjustedSellPrice(item);
		avatarGold += sellPrice;
		avatarInventory.removeFromInventory(item);
		shopkeeperInventory.addToInventory(item);
	}
}
