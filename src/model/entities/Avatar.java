package model.entities;

import model.map.Journal;
import model.map.Tile;


public class Avatar extends Entity {
    private Journal myJournal;

	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromTile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tile getContainingTile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity clone() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    public void notifyOfTileChange(Tile t){
        updateMemTile(t);
    }
    private void updateMemTile(Tile t){
        myJournal.updateMemTile(t);
    }
}
