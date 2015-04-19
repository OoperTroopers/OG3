package utilities;

/**
 * This class defines all of the operations that allow for Tile traversal. 
 * @author Cormac McCarthy
 */

import java.util.*;
import java.awt.Point;
import java.io.*;

import view.tools.Constants;
import model.map.Tile;

/**
 * TileAlgorithm defines all of the methods (and the Direction enum) that are used to
 * traverse a graph and find Tiles.
 * @author Cormac McCarthy
 *
 */
public class TileAlgorithm {

	/**
	 * The enum Direction will be used to denote all possible directions one could face, as well
	 * as how the {x, y, z} coordinates change as you move in that direction.
	 * @author Cormac
	 */
	public enum Direction {
		NORTHWEST(-1, 1, 0),
		SOUTHWEST(-1, 0, 1),
		SOUTH    (0, -1, 1),
		SOUTHEAST(1, -1, 0),
		NORTHEAST(1, 0, -1),
		NORTH    (0, 1, -1);

		/*
		 * The following block of code is used to determine which Direction is to the 
		 * left and to the right of a Direction.
		 */
		static {
			NORTHWEST.left = SOUTHWEST;
			SOUTHWEST.left = SOUTH;
			SOUTH.left = SOUTHEAST;
			SOUTHEAST.left = NORTHEAST;
			NORTHEAST.left = NORTH;
			NORTH.left = NORTHWEST;

			NORTHWEST.right = NORTH;
			SOUTHWEST.right = NORTHWEST;
			SOUTH.right = SOUTHWEST;
			SOUTHEAST.right = SOUTH;
			NORTHEAST.right = SOUTHEAST;
			NORTH.right = NORTHEAST;
		}

		final int dx;
		final int dy;
		final int dz;

		private Direction left;
		private Direction right;

		Direction(int dx, int dy, int dz) {
			this.dx = dx;
			this.dy = dy;
			this.dz = dz;
		}
		
		public int getDX() { return dx; }
		public int getDY() { return dy; }
		public int getDZ() { return dz; }

		public Direction leftTurn() { return this.left; }
		public Direction rightTurn() { return this.right; }
	}

	/**
	 * Uses any Tile with a Location to determine the Location of every other
	 * Tile in the map.
	 * @param start the beginning Tile
	 */
	public static void initializeLocations(Tile start) {
		HashSet<Tile> visited = new HashSet<Tile>();
		Queue<Tile> queue = new LinkedList<Tile>();
		queue.add(start);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			Tile current = queue.remove();
			for (Direction direction : Direction.values()) {
				Tile neighbor = current.getNeighbor(direction);
				if (neighbor != null && !visited.contains(neighbor)) {
					int x = current.getX() + direction.dx;
					int y = current.getY() + direction.dy;
					int z = current.getZ() + direction.dz;
					neighbor.setLocation(x, y, z);
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
	}
	
	/**
	 * Finds all of the Tiles in the map and returns them in a list
	 * @param start Tile that we are starting from
	 * @return      List of all Tiles in the map
	 */
	public static List<Tile> getAllTiles(Tile start) {
		List<Tile> tiles = new ArrayList<Tile>();
		HashSet<Tile> visited = new HashSet<Tile>();
		Queue<Tile> queue = new LinkedList<Tile>();
		
		tiles.add(start);
		queue.add(start);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			Tile current = queue.remove();
			for (Direction direction : Direction.values()) {
				Tile neighbor = current.getNeighbor(direction);
				if (neighbor != null && !visited.contains(neighbor)) {
					tiles.add(neighbor);
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
		
		return tiles;
	}
	
	
	/**
	 * Finds the maximum difference between the x, y, and z coodinates of two Tiles
	 * in order to find the distance between them.
	 * @param t1  the first Tile
	 * @param t2  the second Tile
	 * @return    the distance from the first Tile to the second Tile 
	 */
	public static int distance(Tile t1, Tile t2) {
		int dx = Math.abs(t1.getX() - t2.getX());
		int dy = Math.abs(t1.getY() - t2.getY());
		int dz = Math.abs(t1.getZ() - t2.getZ());
		return Math.max(dx, Math.max(dy, dz));
	}

	/**
	 * Finds all of the Tiles that are found within a specified radius of the
	 * center Tile; the list of Tiles includes the center Tile. This method uses
	 * breadth-first search (BFS) to radiate out of the center Tile to find more
	 * Tiles within the given radius.
	 * @param tile    the center Tile
	 * @param radius  how far out from the center Tile the search goes
	 * @return        a List containing all Tiles that are within a specified 
	 * 				  radius of the center Tile
	 */
	public static List<Tile> getAllTilesWithinRadius(Tile tile, int radius) {
		if (radius < 0) return new ArrayList<Tile>();
		
		// tiles will keep track of all Tiles within the radius
		List<Tile> tiles = new ArrayList<Tile>();
		// queue will keep track of which Tile to BFS out of next
		Queue<DistanceTile> queue = new LinkedList<DistanceTile>();
		// visited keeps track of which Tiles we have already visited
		HashSet<Tile> visited = new HashSet<Tile>();

		// add the center Tile to tiles and visited
		tiles.add(tile);
		visited.add(tile);
		// add a new DistanceTile to the queue, which maps a Tile to the distance from the
		// center Tile; allows us to keep track of how far away we are
		queue.add(new DistanceTile(tile, 0));

		// while there are still Tiles to BFS from, continue radiating outwards
		while (!queue.isEmpty()) {
			// get the current DistanceTile
			DistanceTile current = queue.remove();
			// skip this DistanceTile if we are at the boundary (don't want to add
			// any of its neighbors because they either have been visited already or
			// are past the radius we are interested in
			if (current.getDistance() == radius) continue;

			// iterate through all of the current Tile's neighbors
			for (Direction direction : Direction.values()) {
				Tile neighbor = current.getTile().getNeighbor(direction);
				// if the Tile is on the map and we haven't visited it already
				if (neighbor != null && !visited.contains(neighbor)) {
					// add the neighbor to the list of tiles, mark it as visited, and
					// add it to the queue to be checked
					tiles.add(neighbor);
					visited.add(neighbor);
					// increment the radius in the DistanceTile since we are moving out
					// one Tile from the Tile we are currently on
					queue.add(new DistanceTile(neighbor, current.getDistance() + 1));
				}
			}
		} 
		// finally, return the list of Tiles
		return tiles;
	}

	/**
	 * Finds all of the Tiles that are exactly a specified radius away from the given
	 * center Tile. Uses the same algorithm as getAllTilesWithinRadius, but only adds
	 * a Tile to the list of it is exactly "radius" distance away.
	 * @param tile    the center Tile
	 * @param radius  how far out from the center Tile the search goes
	 * @return        a List containing all Tiles that are exactly a specified 
	 * 				  radius away from the center Tile
	 */
	public static List<Tile> getAllTilesInRadiusRing(Tile tile, int radius) {
		List<Tile> tiles = new ArrayList<Tile>();
		Queue<DistanceTile> q = new LinkedList<DistanceTile>();
		HashSet<Tile> visited = new HashSet<Tile>();

		if (radius == 0) {
			tiles.add(tile);
			return tiles;
		}

		visited.add(tile);
		q.add(new DistanceTile(tile, 0));

		while (!q.isEmpty()) {
			DistanceTile current = q.remove();
			if (current.getDistance() == radius) {
				// only difference from findAllTilesWithinRadius, as it adds the 
				// Tile to the list when it is exactly "radius" distance away
				tiles.add(current.getTile());
				continue;
			}
			for (Direction direction : Direction.values()) {
				Tile neighbor = current.getTile().getNeighbor(direction);
				if (neighbor != null && !visited.contains(neighbor)) {
					visited.add(neighbor);
					q.add(new DistanceTile(neighbor, current.getDistance() + 1));
				}
			}
		} 
		return tiles;
	}

	/**
	 * Finds all the Tiles in a straight line from the beginning Tile (in the given Direction)
	 * @param t         the beginning Tile
	 * @param direction the Direction that we are moving
	 * @return          a list of Tiles that are visited in a straight line
	 */
	public static List<Tile> getAllTilesInStraightLine(Tile t, Direction direction) {
		List<Tile> tiles = new ArrayList<Tile>();
		t = t.getNeighbor(direction);
		// keep going in the given Direction while a Tile still exists
		while (t != null) {
			tiles.add(t);
			t = t.getNeighbor(direction);
		}
		return tiles;
	}

	/**
	 * Finds all the Tiles in a straight line from the beginning Tile (in the given Direction)
	 * that are within a specified distance.
	 * @param t        the beginning Tile
	 * @param dir      the Direction that we are moving
	 * @param distance the distance we are (potentially) traveling
	 * @return         a list of Tiles that are visited in a straight line and 
	 * 				   within a specified distance from the beginning Tile
	 */
	public static List<Tile> getAllTilesInStraightLineDistanceAway(Tile t, Direction direction, int distance) {
		List<Tile> tiles = new ArrayList<Tile>();
		if (distance <= 0) return tiles;
		t = t.getNeighbor(direction);
		while (t != null && distance > 0) {
			tiles.add(t);
			distance--;
			t = t.getNeighbor(direction);
		} 
		return tiles;
	}

	/**
	 * Find all the Tiles within an angular range of the beginning Tile. Refer to the
	 * chart that Dave posted in "Iteration 3" requirements to see how it works.
	 * @param t         the beginning Tile
	 * @param direction the Direction that we are aiming the angular "blast"
	 * @return          a list of Tiles that are within the angular range
	 */
	public static List<Tile> getAllTilesInAngular(Tile t, Direction direction) {
		List<Tile> tiles = new ArrayList<Tile>();
		// get all of the Tiles within a straight line in the specified Direction
		tiles = getAllTilesInStraightLine(t, direction);
		tiles.add(t);
		int size = tiles.size() - 1;

		for (int i = 1; i <= size; i++) {
			// get the Tile that is "i" tiles away
			Tile current = tiles.get(i - 1);

			// get the Direction to the left of the specified Direction
			Direction left = direction.leftTurn();
			// get the Direction to the right of the specified Direction
			Direction right = direction.rightTurn();

			// get all of the Tiles in a straight line to the left of the current Tile that are 
			// "i" tiles away
			List<Tile> leftTiles = getAllTilesInStraightLineDistanceAway(current, left, i);
			// get all of the Tiles in a straight line to the right of the current Tile that are
			// "i" tiles away
			List<Tile> rightTiles = getAllTilesInStraightLineDistanceAway(current, right, i);

			// add all of the Tiles from the left and right
			for (Tile leftTile : leftTiles) tiles.add(leftTile);
			for (Tile rightTile : rightTiles) tiles.add(rightTile);
		}
		// return the list of Tiles
		return tiles;
	}
	
	/**
	 * Calculate the number of Tiles in the map using BFS
	 * @param start Tile that the BFS is starting from
	 * @return	    number of Tiles in the map
	 */
	public static int getNumberOfTiles(Tile start) {
		Queue<Tile> queue = new LinkedList<Tile>();
		HashSet<Tile> visited = new HashSet<Tile>();
		
		queue.add(start);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			Tile current = queue.remove();
			for (Direction direction : Direction.values()) {
				Tile neighbor = current.getNeighbor(direction);
				if (neighbor != null && !visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
		
		return visited.size();
	}
	
	/**
	 * Gets the Direction that an NPC should move in order to minimize the distance to the Avatar
	 * @param npc    Tile the NPC is currently located on
	 * @param avatar Tile the Avatar is currently located on
	 * @return		 Direction that the NPC should travel to get to the Avatar
	 */
	public static Direction getBestDirectionToAvatar(Tile npc, Tile avatar) {
		Queue<DistanceTile> queue = new LinkedList<DistanceTile>();
		HashSet<Tile> visited = new HashSet<Tile>();
		
		queue.add(new DistanceTile(npc, 0));
		visited.add(npc);
		
		DistanceTile current = null;
		
		while (!queue.isEmpty()) {
			current = queue.remove();
			if (current.getTile().equals(avatar)) break;
			for (Direction direction : Direction.values()) {
				Tile neighbor = current.getTile().getNeighbor(direction);
				if (neighbor != null && !visited.contains(neighbor)) {
					visited.add(neighbor);
					DistanceTile neighborDT = new DistanceTile(neighbor, current.getDistance() + 1, current.getPath());
					neighborDT.addDirection(direction);
					queue.add(neighborDT);
				}
			}
		}
		
		HashMap<Direction, Integer> directionToNum = new HashMap<Direction, Integer>();
		for (Direction direction : Direction.values()) directionToNum.put(direction, 0);
		List<Direction> directions = current.getPath();
		for (Direction direction : directions) {
			directionToNum.put(direction, directionToNum.get(direction) + 1);
		}
		
		Direction bestDirection = null;
		int max = -1;
		
		for (Direction direction : Direction.values()) {
			int num = directionToNum.get(direction);
			if (num > max) {
				max = num;
				bestDirection = direction;
			}
		}
		
		return bestDirection;
	}
	
	/**
	 * Used to paint the Tiles to the screen by converting their Location to pixels
	 * @param tile Tile that we are converting to pixels
	 * @return	   Point that contains an {x, y} coordinate of the pixel to print at
	 */
	public static Point toPixel(Tile tile) {
		double size = Constants.TILE_SIZE;
		int x = (int) (size * 3.0 / 2.0 * tile.getX());
		int y = (int) (size * Math.sqrt(3) * (tile.getZ() + tile.getX() / 2.0));
		return new Point(x, y);
	}

	/**
	 * DistanceTile is used for graph traversal by mapping a Tile to the distance it is
	 * away from a center Tile. It should only be used within TileAlgorithm.
	 * @author Cormac
	 *
	 */
	private static class DistanceTile {
		private Tile tile;
		private int distance;
		private List<Direction> path;

		public DistanceTile(Tile tile, int distance) {
			this.tile = tile;
			this.distance = distance;
			this.path = new ArrayList<Direction>();
		}
		
		public DistanceTile(Tile tile, int distance, List<Direction> path) {
			this.tile = tile;
			this.distance = distance;
			this.path = path;
		}

		public int getDistance() {
			return this.distance;
		}

		public Tile getTile() {
			return this.tile;
		}
		
		public List<Direction> getPath() {
			return this.path;
		}
		
		public void addDirection(Direction direction) {
			this.path.add(direction);
		}
	}
}
