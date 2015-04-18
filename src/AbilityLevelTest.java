import model.abilities.*;
import model.occupations.*;
import model.statistics.*;
import model.equipmentmanagers.*;
import model.entities.*;
import model.items.*;

public class AbilityLevelTest {
	public static void main(String[] args) {
		Avatar smash = new Avatar();
		OneHanded oh = new OneHanded();
		smash.addItemToInventory(oh);
		smash.getStats().increaseExperience(140);
		
		AbilityMenu am = new AbilityMenu(smash.getOccupation().getAbilityList(), 
				smash.getStats().getDerivedStats(), smash.getStats().getAssignableAbilityPoints());

		System.out.println(smash.getStats().getOffensiveRating());
		oh.equip(smash.getEquipmentManager(), smash.getInventory());
		System.out.println(smash.getStats().getOffensiveRating());
		
		System.out.println(smash.getStats().getAssignableAbilityPoints());
		for(int i = 0; i < 16; i++) {
			am.assignAbilityPoint(smash.getOccupation().getAbilityList().get(3));
		}
		System.out.println(smash.getStats().getOffensiveRating());
		
		smash.getStats().setAssignableAbilityPoints(am.openAbilityMenu());
		System.out.println(smash.getStats().getAssignableAbilityPoints());
	}

}