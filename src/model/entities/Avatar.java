package model.entities;

import controller.ControllerAvatar;
import model.abilities.Ability;
import model.abilities.ExplicitAbility;
import model.abilities.ImplicitAbility;
import model.effects.Effect;
import model.equipmentmanagers.EquipmentManager;
import model.map.Journal;
import model.map.MovementCapabilities;
import model.map.Tile;
import model.occupations.Occupation;
import model.statistics.Statistics;

import java.awt.List;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import utilities.TileAlgorithm;
import view.modelview.tileable.entities.AvatarView;
import view.view.ActiveGameViewport;


public class Avatar extends Entity {
	
    private Journal myJournal;
	private ControllerAvatar controlAvatar;

	public Avatar(){
		super();
		this.controlAvatar = new ControllerAvatar(this);
		this.controlAvatar.setDefaultAbilityKeys();
		this.myJournal = new Journal();
	}
	
	public Avatar(Occupation o, EquipmentManager em, Statistics s) {
		super(o, em, s);
		//this.location = new Location();
		this.controlAvatar = new ControllerAvatar(this);
		this.myJournal = new Journal();
	}
	
	public Avatar(Tile tile) {
		super(tile, new AvatarView());
		this.controlAvatar = new ControllerAvatar(this);
		this.controlAvatar.setDefaultAbilityKeys();
		this.myJournal = new Journal();
	}

	public ArrayList<KeyListener> getKeyBinding(){
		return controlAvatar.getKbList();
	}
    
	@Override
	public void acceptEffect(Effect e) {
		// TODO Auto-generated method stub
		
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
    
    @Override
    public void onMove(){
    	
    	java.util.List<Tile> tiles = TileAlgorithm.getAllTilesWithinRadius(getTile(), this.getObservationAbilityLevel());
    	for(Tile t: tiles){
    		t.updateTileView();
    	}
    }
    
    private void updateMemTile(Tile t){
        myJournal.addMemTile(t);
    }

	@Override
	public MovementCapabilities getMovementCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addAbility(ExplicitAbility ability) {
		this.getOccupation().addAbility(ability);
		ability.attachToController(controlAvatar);
	}

	@Override
	public void update(Tile tile) {
		controlAvatar.update(this, tile);
		ActiveGameViewport.getInstance().setAvatarTile(tile);	
	}

}
