import model.entities.*;
import model.statistics.*;
import model.equipmentmanagers.*;
import model.occupations.*;

public class EntityTest {
	public static void main(String[] args) {
		Occupation occ = new SmasherOccupation();
		Statistics stat = new SmasherStatistics();
		EquipmentManager sem = new SmasherEquipmentManager(stat.getDerivedStats());
		Avatar smasher = new Avatar(occ, sem, stat);
		
		System.out.println(smasher.getStats().getOffensiveRating());
	}
}
