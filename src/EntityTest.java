import model.entities.*;
import model.statistics.*;
import model.equipmentmanagers.*;
import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;
import model.occupations.*;

public class EntityTest {
	public static void main(String[] args) {
		Load lo = new Load();
		try{
			lo.read(FilePaths.DEFAULT);}
		catch(Exception e) {}
		Tile bTile = lo.getBeginningTile();
		Occupation occ = new SmasherOccupation();
		Statistics stat = new SmasherStatistics();
		EquipmentManager sem = new SmasherEquipmentManager(stat.getDerivedStats(), occ);
		Avatar smasher = new Avatar(occ, sem, stat, bTile);
		
		System.out.println(smasher.getStats().getOffensiveRating());
	}
}
