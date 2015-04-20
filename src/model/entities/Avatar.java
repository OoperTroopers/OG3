package model.entities;

import controller.ControllerAvatar;
import model.abilities.ExplicitAbility;
import model.abilities.UnMountAbility;
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
import utilities.TileAlgorithm.Direction;
import view.modelview.tileable.entities.AvatarView;
import view.view.ActiveGameViewport;
import view.view.ExtendedStatsViewport;


public class Avatar extends Entity {
	
    private Journal myJournal;
	private ControllerAvatar controlAvatar;
	private Mount mount;
	private int radiusOfVision;
	
	public Avatar(){
		super();
		this.controlAvatar = new ControllerAvatar(this);
		this.controlAvatar.setDefaultAbilityKeys();
		this.myJournal = new Journal();
		this.radiusOfVision = 3;
		onMove();
	}
	
	public Avatar(Occupation o, EquipmentManager em, Statistics s, Tile tile) {
		super(o, em, s, tile, new AvatarView());
		//this.location = new Location();
		this.controlAvatar = new ControllerAvatar(this);
		this.myJournal = new Journal();
		this.radiusOfVision = 3;
		onMove();
	}
	
	public Avatar(Tile tile) {
		super(tile, new AvatarView());
		this.controlAvatar = new ControllerAvatar(this);
		this.controlAvatar.setDefaultAbilityKeys();
		this.myJournal = new Journal();
		this.radiusOfVision = 3;
		onMove();
	}

	public ArrayList<KeyListener> getKeyBinding(){
		return controlAvatar.getKbList();
	}
    
	@Override
	public void acceptEffect(Effect e) {
		
	}

	@Override
	public boolean isTraversable() {
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
    	
    	java.util.List<Tile> tiles = TileAlgorithm.getAllTilesWithinRadius(getTile(), this.radiusOfVision);
    	for(Tile t: tiles){
    		t.updateTileView();
    	}
    	
    }
    
    public void increaseRadiusOfVision(int amount) {
    	this.radiusOfVision += amount;
    }
    
    public void decreaseRadiusOfVision(int amount) {
    	this.radiusOfVision = Math.max(0, this.radiusOfVision - amount);
    }
    
    private void updateMemTile(Tile t){
        myJournal.addMemTile(t);
    }

	@Override
	public MovementCapabilities getMovementCapabilities() {
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
	
	public ControllerAvatar getControlAvatar() {
		return controlAvatar;
	}
	public void setcontrolAvatar(ControllerAvatar controlAvatar) {
		this.controlAvatar = controlAvatar;
	}
	
	public void acceptMount(Mount mount) {
		this.mount = mount;
		this.setMount(mount);
		this.addAbility(new UnMountAbility(' '));
	}
	
	public void removeMount() {
		System.out.println("removes mount");
		this.mount.unmount();
		this.setMount(null);
	}
	
	public boolean mounted() {
		return this.mount == null ? false : true;
	}
}
