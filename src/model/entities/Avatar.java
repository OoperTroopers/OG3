package model.entities;

import controller.ControllerAvatar;
import model.abilities.ExplicitAbility;
import model.effects.Effect;
import model.equipmentmanagers.EquipmentManager;
import model.map.Journal;
import model.map.MovementCapabilities;
import model.map.Tile;
import model.map.Tileable;
import model.occupations.Occupation;
import model.statistics.Statistics;

import java.awt.List;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import utilities.TileAlgorithm;
import view.modelview.tileable.entities.AvatarView;
import view.view.ActiveGameViewport;
import view.view.ExtendedStatsViewport;


public class Avatar extends Entity {
	
    private Journal myJournal;
	private ControllerAvatar controlAvatar;

	public Avatar(){
		super();
		this.controlAvatar = new ControllerAvatar(this);
		this.controlAvatar.setDefaultAbilityKeys();
		this.myJournal = new Journal();
		onMove();
	}
	
	public Avatar(Occupation o, EquipmentManager em, Statistics s, Tile tile) {
		super(o, em, s, tile, new AvatarView());
		//this.location = new Location();
		this.controlAvatar = new ControllerAvatar(this);
		this.myJournal = new Journal();
		onMove();
	}
	
	public Avatar(Tile tile) {
		super(tile, new AvatarView());
		this.controlAvatar = new ControllerAvatar(this);
		this.controlAvatar.setDefaultAbilityKeys();
		this.myJournal = new Journal();
		onMove();
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
    	
    	ArrayList<Tileable> tileables = getTile().getTileables();
    	Tileable[] arrayTileables = new Tileable[tileables.size()];
    	for (int i = 0; i < tileables.size(); i++) arrayTileables[i] = tileables.get(i);
    	for (Tileable tileable : arrayTileables) {
    		this.interact(tileable);
    	}
    	
    	System.out.println("STATISTICS!!!");
    	System.out.println(this.getStats());
    	
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
	
	public void interact(Tileable tileable) {
		tileable.acceptAvatar(this);
	}
	
	public void acceptAvatar(Avatar avatar) {}
}
