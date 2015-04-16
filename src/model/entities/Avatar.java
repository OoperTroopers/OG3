package model.entities;

import model.map.Journal;
import model.map.Tile;


public class Avatar extends Entity {
    private Journal myJournal;
    
    
    public void notifyOfTileChange(Tile t){
        updateMemTile(t);
    }
    private void updateMemTile(Tile t){
        myJournal.updateMemTile(t);
    }
}
