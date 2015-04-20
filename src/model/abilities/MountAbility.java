package model.abilities;

import model.entities.Entity;
import model.entities.Mount;
import model.map.Tile;
import model.map.Tileable;

public class MountAbility extends ExplicitAbility {
	Entity avatar;
	Mount mount;
	public MountAbility() {
		super();
	}
	
	public MountAbility(char keyToBind) {
		super();
		setName("Mount Ability");
		System.out.println("Mount ability initialized");

	}
	
	public MountAbility(Entity avatar, char keyToBind) {
		super();
		this.avatar = avatar;
		setName("Mount Ability");
		
	}
	
	public void setMount(Mount mount) {
		this.mount = mount;
	}
	
	 @Override
	 public void perform() {
		searchForMount();
		System.out.println("I MOUNTED");
	} 
	 
	 public void searchForMount() {
		 Tile tile = avatar.getTile();
		 for (Tileable t : tile.getTileables()) {
			 
		 }
	 }
}
