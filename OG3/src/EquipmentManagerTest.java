import model.entities.*;
import model.items.*;
import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;

public class EquipmentManagerTest {
	public static void main(String[] args) {
		Load lo = new Load();
		try{
		lo.read(FilePaths.DEFAULT);}
		catch(Exception e) {}
		Tile bTile = lo.getBeginningTile();
		Avatar smash = new Avatar(bTile);
		Helmet helmet = new Helmet();
		smash.addItemToInventory(helmet);
		
		TwoHanded thw = new TwoHanded();
		smash.addItemToInventory(thw);
		System.out.println(smash.getItemFromInvnetory(thw).getName());
		System.out.println("offense: " + smash.getStats().getOffensiveRating());
		thw.equip(smash.getEquipmentManager(), smash.getInventory());
		System.out.println("offense: " + smash.getStats().getOffensiveRating());

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
