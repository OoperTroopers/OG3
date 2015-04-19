package model.loadsave;

import java.util.*;
import java.io.*;

import utilities.TileAlgorithm;
import utilities.TileAlgorithm.Direction;

import model.map.Tile;

public class Save {
	
	private PrintWriter out;
	private HashMap<Tile, Integer> tileNumbering;
	private int tileNumber;
	
	/**
	 * Writes the entire state of a game to a file so that it may be loaded at a later time.
	 * @param fileName   String containing the file name that we are writing to
	 * @param avatarTile Tile that the Avatar is currently on
	 * @throws IOException
	 */
	public void write(String fileName, Tile avatarTile) throws IOException {
		File file = new File(fileName);
		this.out = new PrintWriter(file);
		this.tileNumbering = new HashMap<Tile, Integer>();
		this.tileNumber = 0;
		
		// write all of the Tiles to the file
		this.writeTiles(avatarTile);
		
		// write the Avatar's location
		this.writeAvatarLocation(avatarTile);
		
		out.close();
	}
	
	/**
	 * Writes all of the Tiles and their neighbors to the file
	 * @param start Tile that we are starting from (Avatar's Tile)
	 */
	private void writeTiles(Tile start) {
		// get the number of Tiles in the map
		int numberOfTiles = TileAlgorithm.getNumberOfTiles(start);
		// write the number of Tiles
		this.out.println("NumberOfTiles=" + numberOfTiles);
		
		// use BFS to find all of the Tiles
		Queue<Tile> queue = new LinkedList<Tile>();
		HashSet<Tile> visited = new HashSet<Tile>();
		
		queue.add(start);
		visited.add(start);
		// initialize the starting Tile to index 1
		this.setTileNumber(start);
		
		while (!queue.isEmpty()) {
			// get the current Tile and write it to the file
			Tile current = queue.remove();
			out.println("Tile=" + this.getTileNumber(current));
			
			// create a String that will be written to the file
			String currentString = "";
			currentString += "Neighbors=";
			
			for (Direction direction : Direction.values()) {
				Tile neighbor = current.getNeighbor(direction);
				// if the neighbor does not exist, write nothing
				if (neighbor == null) currentString += ",";
				else {
					int tileNumber = -1;
					// set tileNumber if the Tile has a number, create a number if it doesn't exist
					if (this.hasTileNumber(neighbor)) tileNumber = this.getTileNumber(neighbor);
					else tileNumber = this.setTileNumber(neighbor);
					
					// write the current tileNumber
					currentString += tileNumber + ",";
					
					// add the neighbor to the Queue if it hasn't been visited yet
					if (!visited.contains(neighbor)) {
						visited.add(neighbor);
						queue.add(neighbor);
					}
				}
			}
			// cut off the last comma
			currentString = currentString.substring(0, currentString.length() - 1);
			// write the entire String to the file
			out.println(currentString);
		}
	}
	/**
	 * Checks to see if the Tile has a number in the HashMap
	 * @param tile Tile that we are checking
	 * @return     true if the Tile has a number, false otherwise
	 */
	private boolean hasTileNumber(Tile tile) {
		return this.tileNumbering.get(tile) != null;
	}
	
	/**
	 * Receives the number for the corresponding Tile
	 * @param tile Tile that we want to get the number for
	 * @return     the number of the Tile
	 */
	private int getTileNumber(Tile tile) {
		return this.tileNumbering.get(tile);
	}
	
	/**
	 * Gives the Tile a number and increments the Tile number counter
	 * @param tile Tile that we want to assign a number
	 * @return     the number of the Tile
	 */
	private int setTileNumber(Tile tile) {
		this.tileNumbering.put(tile, ++this.tileNumber);
		return this.tileNumber;
	}
	
	private void writeAvatarLocation(Tile avatarTile) {
		int tileIndex = this.getTileNumber(avatarTile);
		out.print("AvatarLocation=" + tileIndex);
	}
}
