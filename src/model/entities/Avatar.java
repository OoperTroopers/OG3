package model.entities;

import model.effects.Effect;
import model.map.Journal;
import model.map.Location;
import model.map.MovementCapabilities;
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
	
	public Journal getMyJournal() {
		return myJournal;
	}
	public void setMyJournal(Journal myJournal) {
		this.myJournal = myJournal;
	}
    
    
    public void notifyOfTileChange(Tile t){
        updateMemTile(t);
    }
    private void updateMemTile(Tile t){
        //myJournal.addMemTile(t);
    }

	@Override
	public MovementCapabilities getMovementCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canMoveNorth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveNortheast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveNorthwest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveSouth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveSoutheast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMoveSouthwest() {
		// TODO Auto-generated method stub
		return false;
	}
}
