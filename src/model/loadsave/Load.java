package model.loadsave;

import java.io.*;
import java.util.*;

import model.areaeffect.*;
import model.entities.*;
import model.items.*;
import model.map.*;
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
			String terrain = in.next();
			
			String nextLine = in.next();
			if (this.initializeEntity(tileNumber, nextLine)) nextLine = in.next();
			if (this.initializeItem(tileNumber, nextLine)) nextLine = in.next();
			if (this.initializeAreaEffect(tileNumber, nextLine)) nextLine = in.next();
			
			String neighbors = nextLine;
			this.initializeTerrain(tileNumber, terrain);
			this.initializeNeighbors(tileNumber, neighbors);
		}
		
		// initialize all locations with Tile 1 having coordinates {0, 0, 0}
		this.initializeLocations(this.allTiles[1]);
		
		// get the Tile that the Avatar is on
		String avatarLocation = in.next();
		Tile avatarTile = this.getAvatarTile(avatarLocation);
		
		// set the reference to the beginning Tile (Avatar's Tile)
		this.setBeginningTile(avatarTile);	
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
			this.allTiles[i] = new Tile(i);
		}
	}
	
	private boolean initializeItem(String tileNumber, String item) {
		String type = item.substring(0, item.indexOf("="));
		if (!type.equals("Item")) return false;
		int index = this.parseTileNumber(tileNumber);
		Tile tile = this.getTile(index);
		item = item.substring(item.indexOf("=") + 1);
		Item tileableItem = this.parseItem(item);
		// if (tileableItem instanceof Icicle) System.out.println(tileNumber); 
		tile.addTileable(tileableItem);
		return true;
	}
	
	private Item parseItem(String item) {
		if (item.equals("Potion")) return new Potion();
		if (item.equals("HealOS")) return new HealingOneShotItem();
		if (item.equals("DamageOS")) return new DamagingOneShotItem();
		if (item.equals("TreasureChest")) return new TreasureChest();
		if (item.equals("Door")) return new Door();
		if (item.equals("Icicle")) {
			// System.out.print ("Icicle is at ");
			return new Icicle();
		}
		return this.parseArmor(item);
	}
	
	private Item parseArmor(String item) {
		if (item.equals("Arms")) return new Arms();		
		if (item.equals("Chest")) return new Chest();
		if (item.equals("Helmet")) return new Helmet();
		if (item.equals("Legs")) return new Legs();		
		if (item.equals("Saddle")) return new Saddle();
		if (item.equals("Shield")) return new Shield();	
		return this.parseWeapon(item);
	}
	
	private Item parseWeapon(String item) {
		if (item.equals("Brawl")) return new Brawl();
		if (item.equals("OneHanded")) return new OneHanded();
		if (item.equals("Ranged")) return new Ranged();
		if (item.equals("Staff")) return new Staff();
		if (item.equals("TwoHanded")) return new TwoHanded();
		return null;
	}
	
	private boolean initializeAreaEffect(String tileNumber, String areaEffect) {
		String type = areaEffect.substring(0, areaEffect.indexOf("="));
		if (!type.equals("AreaEffect")) return false;
		int index = this.parseTileNumber(tileNumber);
		Tile tile = this.getTile(index);
		areaEffect = areaEffect.substring(areaEffect.indexOf("=") + 1);
		AreaEffect tileableAreaEffect = this.parseAreaEffect(areaEffect);
		tile.addTileable(tileableAreaEffect);
		return true;
	}
	
	private AreaEffect parseAreaEffect(String areaEffect) {
		if (areaEffect.equals("Heal")) return new HealDamageAreaEffect();
		if (areaEffect.equals("Damage")) return new TakeDamageAreaEffect();
		if (areaEffect.equals("Death")) return new InstantDeathAreaEffect();
		if (areaEffect.equals("Level")) return new LevelUpAreaEffect();
		if (areaEffect.equals("Trap")) return new TrapAreaEffect();
		if (areaEffect.indexOf("Teleport") >= 0) return this.createTeleport(areaEffect);
		return null;
	}
	
	private AreaEffect createTeleport(String teleportAreaEffect) {
		teleportAreaEffect = teleportAreaEffect.substring(teleportAreaEffect.indexOf("=") + 1);
		int tileNumber = this.parseTileNumber(teleportAreaEffect);
		return new TeleportAreaEffect(this.allTiles[tileNumber]);
	}
	
	private boolean initializeEntity(String tileNumber, String entity) {
		String type = entity.substring(0, entity.indexOf("="));
		if (!type.equals("Entity")) return false;
		int index = this.parseTileNumber(tileNumber);
		Tile tile = this.getTile(index);
		entity = entity.substring(entity.indexOf("=") + 1);
		Entity tileableEntity = this.parseEntity(entity, tile);
		tile.addTileable(tileableEntity);
		return true;
	}
	
	private Entity parseEntity(String entity, Tile tile) {
		if (entity.equals("Shopkeeper")) return new Shopkeeper(tile);
		if (entity.equals("NPC")) return new NPC(tile);
		if (entity.equals("Pet")) return new Pet(tile);
		if (entity.equals("Mount")) return new Mount(tile);
		return null;
	}
	
	private void initializeTerrain(String tileNumber, String tileTerrain) {
		int index = this.parseTileNumber(tileNumber);
		Tile tile = this.getTile(index);
		
		Terrain terrain = this.parseTerrain(tileTerrain);
		tile.addTileable(terrain);
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
	
	private Terrain parseTerrain(String terrain) {
		terrain = terrain.substring(terrain.indexOf("=") + 1);
		char t = terrain.charAt(0);
		if (t == 'M') return new MountainTerrain();
		if (t == 'G') return new GrassTerrain();
		if (t == 'W') return new WaterTerrain();
		if (t == 'R') { // next part is the direction
			String direction = terrain.substring(1);
			Direction d = Direction.SOUTH;
			if (direction.equals("N")) 			d = Direction.NORTH;
			else if (direction.equals("NW")) 	d = Direction.NORTHWEST;
			else if (direction.equals("NE")) 	d = Direction.NORTHEAST;
			else if (direction.equals("S")) 	d = Direction.SOUTH;
			else if (direction.equals("SE")) 	d = Direction.SOUTHEAST;
			else if (direction.equals("SW")) 	d = Direction.SOUTHWEST;
			
			return new RiverTerrain(d);
		}
		return null;
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
	 * Get the Tile that the Avatar is located on based on the String
	 * @param avatarLocation String with the Avatar's location
	 * @return				 number of the Tile that the Avatar is on
	 */
	private Tile getAvatarTile(String avatarLocation) {
		avatarLocation = avatarLocation.substring(avatarLocation.indexOf("=") + 1);
		int tileNumber = Integer.parseInt(avatarLocation);
		return this.allTiles[tileNumber];
	}
	
	/**
	 * Set the beginning Tile to the first Tile
	 */
	private void setBeginningTile(Tile beginningTile) {
		this.beginningTile = beginningTile;
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
