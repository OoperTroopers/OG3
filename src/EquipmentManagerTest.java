import model.entities.*;
import model.items.*;

public class EquipmentManagerTest {
	public static void main(String[] args) {
		Avatar smash = new Avatar();
		Helmet helmet = new Helmet();
		smash.addItemToInventory(helmet);

		System.out.println(smash.getItemFromInvnetory(helmet).getName());
		System.out.println("Defense: " + smash.getStats().getArmorRating());
		helmet.equip(smash.getEquipmentManager(), smash.getInventory());
		
		System.out.println(smash.getItemFromInvnetory(helmet));
		System.out.println(smash.getEquipmentManager().getHelmet().getName());
		System.out.println("Defense: " + smash.getStats().getArmorRating());
		
		helmet.unequip(smash.getEquipmentManager(), smash.getInventory());
		System.out.println(smash.getItemFromInvnetory(helmet).getName());
		
		System.out.println("Defense: " + smash.getStats().getArmorRating());
	}
}
