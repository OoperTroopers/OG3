import java.util.*;
import java.io.*;

import utilities.TileAlgorithm;

import model.loadsave.Load;
import model.loadsave.Save;
import model.map.Tile;

public class LoadSaveTest {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Load loadObject = new Load();
		Save saveObject = new Save();
		
		// get the file name (new game will load default.cfg)
		System.out.print("Enter file name: ");
		String fileName = in.next();
		loadObject.read(fileName);
		
		// get the starting Tile
		Tile beginningTile = loadObject.getBeginningTile();
	}
}
