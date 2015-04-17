package model.loadsave;

import java.io.*;
import java.util.*;

import model.map.Tile;
import utilities.TileAlgorithm;
import utilities.TileAlgorithm.Direction;

/**
 * Load is responsible for reading a designated configuration file and creating a new game that
 * instantiates the previous game's state
 * @author Cormac McCarthy
 *
 */
public class Load {
	
	private Tile[] allTiles;
	private Tile beginningTile;
	
	/**
	 * Reads from a configuration file that contains a previous game's state and recreates the
	 * entire game
	 * @param fileName String containing the configuration file with the previous game's state
	 * @throws IOException
	 */
	public void read(String fileName) throws IOException {
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		
		// parse the number of tiles in the map
		String numberOfTiles = in.next();
		int tiles = parseNumberOfTiles(numberOfTiles);
		
		// initialize the Tile array that will hold all of the references to each Tile
		this.initializeTileArray(tiles);
		
		// iterate through all Tiles and add their neighbors
		for (int z = 0; z < tiles; z++) {
			String tileNumber = in.next();
			String neighbors = in.next();
			this.initializeNeighbors(tileNumber, neighbors);
		}
		
		// TODO: READ THE AVATAR'S LOCATION
		
		// initialize all locations with Tile 1 having coordinates {0, 0, 0}
		this.initializeLocations(this.allTiles[1]);
		
		// set the reference to the beginning Tile
		this.setBeginningTile(1);	
	}
	
	/**
	 * Parses the String that contains the number of Tiles
	 * @param numberOfTiles String that contains the number of Tiles from the file
	 * @return				the number of Tiles in the game
	 */
	private int parseNumberOfTiles(String numberOfTiles) {
		numberOfTiles = numberOfTiles.substring(numberOfTiles.indexOf("=") + 1);
		return Integer.parseInt(numberOfTiles);
	}
	
	/**
	 * Initializes the array containing all of the references to the Tiles
	 * @param numberOfTiles the number of Tiles in the game
	 */
	private void initializeTileArray(int numberOfTiles) {
		this.allTiles = new Tile[numberOfTiles + 1];
		for (int i = 0; i <= numberOfTiles; i++) {
			this.allTiles[i] = new Tile();
		}
	}
	
	/**
	 * Initializes all of the neighbors of a Tile
	 * @param tileNumber the current Tile we are adding neighbors to
	 * @param neighbors  String containing the neighbors of the Tile
	 */
	private void initializeNeighbors(String tileNumber, String neighbors) {
		int index = this.parseTileNumber(tileNumber);
		Tile tile = this.getTile(index);
		
		Queue<Integer> indices = this.parseNeighbors(neighbors);
		Queue<Tile> tiles = this.getNeighbors(indices);
		
		for (Direction direction : Direction.values()) {
			Tile current = tiles.remove();
			if (current == null) continue;
			tile.addNeighbor(current, direction);
		}
	}
	
	/**
	 * Parses a String that contains a Tile number
	 * @param tileNumber String containing the Tile number
	 * @return           the number of the Tile
	 */
	private int parseTileNumber(String tileNumber) {
		tileNumber = tileNumber.substring(tileNumber.indexOf("=") + 1);
		return Integer.parseInt(tileNumber);
	}
	
	/**
	 * Grabs the reference to the Tile of the index given
	 * @param index the Tile number that we are interested in
	 * @return      the reference to the Tile object corresponding to the index
	 */
	private Tile getTile(int index) {
		return this.allTiles[index];
	}
	
	/**
	 * Parses the String containing the neighbors of a Tile and returns a Queue that contains
	 * the numbers of the neighboring Tiles, -1 if there isn't a neighbor in a direction
	 * @param neighbors String containing the numbers of the neighbors
	 * @return          a Queue containing the Tile numbers of the neighbors, -1 if no neighbor
	 */
	private Queue<Integer> parseNeighbors(String neighbors) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int counter = 0;
		neighbors = neighbors.substring(neighbors.indexOf("=") + 1);
		
		while (neighbors.indexOf(",") >= 0) {
			String index = neighbors.substring(0, neighbors.indexOf(","));
			if (index.equals("")) queue.add(-1);
			else queue.add(Integer.parseInt(index));
			counter++;
			neighbors = neighbors.substring(neighbors.indexOf(",") + 1);
		}
		
		if (neighbors.equals("")) queue.add(-1);
		else queue.add(Integer.parseInt(neighbors));
		
		return queue;
	}
	
	/**
	 * Iterates through the Queue of Tile numbers and returns a Queue that contains a reference
	 * to the corresponding Tile
	 * @param indices Queue containing all of the Tile numbers
	 * @return        Queue containing a reference to each neighboring Tile
	 */
	private Queue<Tile> getNeighbors(Queue<Integer> indices) {
		int size = indices.size();
		Queue<Tile> tiles = new LinkedList<Tile>();
		
		for (Direction direction : Direction.values()) {
			int index = indices.remove();
			if (index == -1) tiles.add(null);
			else tiles.add(this.allTiles[index]);
		}
		
		return tiles;
	}
	
	/**
	 * Using the TileAlgorithm class, initialize the starting Tile to coordinates {0, 0, 0} and
	 * use BFS to set the locations of all other Tiles in the map
	 * @param start Tile that will have the coordinate {0, 0, 0}
	 */
	private void initializeLocations(Tile start) {
		start.setLocation(0, 0, 0);
		TileAlgorithm.initializeLocations(start);
	}
	
	/**
	 * Set the beginning Tile to the first Tile
	 */
	private void setBeginningTile(int index) {
		this.beginningTile = this.allTiles[index];
	}
	
	/**
	 * Get the beginning Tile of the map (Avatar's Tile)
	 * @return Tile that contains the Avatar's location
	 */
	public Tile getBeginningTile() {
		if (this.beginningTileInitiated()) {
			return this.beginningTile;
		}
		System.out.println("Beginning tile has not been initiated.");
		return null;
	}
	
	/**
	 * Checks to see if the beginning Tile has been initiated
	 * @return true if the beginning Tile exists, false otherwise
	 */
	private boolean beginningTileInitiated() {
		return this.beginningTile != null;
	}
	
}