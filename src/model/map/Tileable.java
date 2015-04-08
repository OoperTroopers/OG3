package model.map;

/**
 *
 * @author Jason Owens
 */
public interface Tileable {
    
    public Tile getContainingTile();
    public Tileable clone();
}
