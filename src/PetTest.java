import java.util.*;
import java.io.*;

import model.entities.*;
import model.loadsave.*;
import model.map.*;
import utilities.TileAlgorithm;
import utilities.TileAlgorithm.Direction;

public class PetTest {
	
	public static void main(String[] args) throws IOException {
		
		Load loadObject = new Load();
		loadObject.read(FilePaths.DEFAULT);
		Tile avatarTile = loadObject.getBeginningTile();
		
		List<Tile> tiles = TileAlgorithm.getAllTilesInRadiusRing(avatarTile, 3);
		
		Tile petTile = tiles.get(5);
		
		System.out.println("Avatar location ==> " + avatarTile);
		System.out.println("Pet location ==> " + petTile);
		
		Direction bestDirection = TileAlgorithm.getBestDirectionToAvatar(petTile, avatarTile);
		System.out.println("Best direction ==> " + bestDirection);
		
	}
	
}