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
		
		// get the file to read from (new game will load default.cfg)
		System.out.print("File to read from: ");
		String fileName = in.next();
		loadObject.read(fileName);
		/*
		// get the starting Tile
		Tile beginningTile = loadObject.getBeginningTile();
		
		// get the file to write to
		System.out.print("File to write to: ");
		fileName = in.next();
		saveObject.write(fileName, beginningTile);
		*/
	}
}
