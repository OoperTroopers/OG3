package model.map;

/**
 * The tileable interface defines all of the requirements an object must meet in
 * order to properly be put into a Tile in our game. If an object will be put on a 
 * Tile, it will implement Tileable.
 * @author Jason Owens
 */
public interface Tileable {
    
    
    /**
     * All tileables will need to accept an effect object. The effect
     * object will know what to do.
     * @param e Effect object that is trying to affect the Tileable 
     */
    public void acceptEffect(Effect e);
    
    /**
     * Using Tile's public interface, remove the Tileable from the tile. Use
     * this often for moving, as well as for deleting objects on use. 
     */
    public void removeFromTile();
    
    
    /**
     * Each tileable must have a reference to its containing tile.
     * @return the Tile that the tileable is on
     */
    public Tile getContainingTile();
    
    /**
     * 
     * @return a COPY of the Tileable, not a reference to the Tileable itself
     */
    public Tileable clone();          
    
    /**
     * @param Tileable t
     * @return true if an only if t can share a tile with this Tileable
     */
    public boolean canTraverse(Tileable t); // will return true iff t can share a tile with this Tileable
}
