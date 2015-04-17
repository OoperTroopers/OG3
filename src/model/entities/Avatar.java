package model.entities;

import controller.ControllerAvatar;
import model.abilities.Ability;
import model.effects.Effect;
import model.equipmentmanagers.EquipmentManager;
import model.map.Journal;
import model.map.MovementCapabilities;
import model.map.Tile;
import model.occupations.Occupation;
import model.statistics.Statistics;

import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Avatar extends Entity {
    private Journal myJournal;
	private ControllerAvatar controlAvatar;
	private ArrayList<Ability> abilities;

	public Avatar(){
		super();
		this.controlAvatar = new ControllerAvatar(this);
		this.abilities = new ArrayList<>();
		this.myJournal = new Journal();
	}
	
	public Avatar(Occupation o, EquipmentManager em, Statistics s, boolean h) {
		super(o, em, s);
		//this.location = new Location();
		this.controlAvatar = new ControllerAvatar(this);
		this.abilities = new ArrayList<>();
		this.myJournal = new Journal();
	}
	
	public void addAbility(Ability ability){
		abilities.add(ability);
		ability.attachToController(controlAvatar);
	}

	public ArrayList<KeyListener> getKeyBinding(){
		return controlAvatar.getKbList();
	}
    
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
