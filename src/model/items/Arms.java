package model.items;
import model.effects.Effect;
import model.equipmentmanagers.EquipmentManager;
import model.inventory.Inventory;
import model.map.Tile;
import model.map.Tileable;

public class Arms extends Armor {
	public void equip(EquipmentManager em, Inventory inventory) {
		em.equipArms(this);
		inventory.removeFromInventory(this);
	}
	public void unequip(EquipmentManager em, Inventory inventory) {
		em.unequipArms();
		inventory.addToInventory(this);
	}
	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeFromTile() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Tile getContainingTile() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tileable clone() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}
}
