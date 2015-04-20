import view.modelview.tileable.entities.MountView;
import model.entities.Avatar;
import model.entities.Mount;
import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;


public class MountTest {
	public static void main(String[] args) {
		Load lo = new Load();
		try{
			lo.read(FilePaths.DEFAULT);}
		catch(Exception e) {}
		Tile bTile = lo.getBeginningTile();
		Avatar smasher = new Avatar(bTile);
		Mount mount = new Mount(bTile);
		mount.setTile(smasher.getTile());
		// mount.mount(smasher);
		smasher.moveSouth();
	}
}
