package model.entities;

import java.util.ArrayList;

import view.modelview.tileable.TileableView;

import model.effects.Effect;
import model.map.MovementCapabilities;
import model.map.Tile;
import model.equipmentmanagers.EquipmentManager;
import model.occupations.Occupation;
import model.statistics.Statistics;
//switch to NPC
import view.modelview.tileable.entities.AvatarView;

public class NPC extends Entity {
	private boolean hostile;
	private ArrayList<Entity> aggroList;
	
	public NPC() {
		super();
		this.hostile = true;
		this.aggroList = new ArrayList<Entity>();
	}
	
	public NPC(TileableView entityView) {
		super(entityView);
		this.hostile = true;
		this.aggroList = new ArrayList<Entity>();
	}
	
	// constructor for Entity with specific occupation
	public NPC(Occupation o, EquipmentManager em, Statistics s, boolean h, Tile tile) {
		//switch to NPC view
		super(o, em, s, tile, new AvatarView());
		this.hostile = h;
		this.aggroList = new ArrayList<Entity>();
	}
	
	public void dialgue() {
		System.out.println("I am a god. Fear me.");
	}
	
	public void trackAvatar() {
		//do stuff
	}
	
	@Override
	public void receiveDamage(int damage) {
		damage -= getStats().getDefensiveRating();
		damage = Math.max(0, damage);
		getStats().wound(damage);
		if(getStats().getCurrentHealth() <= 0) {
			respawn();
		}
		hostile = true;
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

	@Override
	public MovementCapabilities getMovementCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public void update(Entity entity, Tile tile) {}

	public void update(Tile tile) {}

	@Override
	public void onMove() {
		// TODO Auto-generated method stub
		
	}
}
