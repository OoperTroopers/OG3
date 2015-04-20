package model.items;

import model.entities.Avatar;
import model.entities.Entity;
import model.map.Location;
import model.map.Tileable;
import view.modelview.tile.TileView;
import view.modelview.tileable.TileableView;


public abstract class Item implements Tileable{	
	private String name;
	private String description;
	private String id;
	private TileableView itemView;

	public Item(TileableView itemView) {
		this.name = "Test";
		this.description = "Test Description";
		this.id = "12345";
		this.itemView = itemView;
	}
	
	public Item(String name, TileableView itemView) {
		this.name = name;
		this.description = "Test Description";
		this.id = "12345";
		this.itemView = itemView;
	}
	
	public Item(String name, String description, String id) {
		this.name = name;
		this.description = description;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public abstract boolean isPassable();
	
	public abstract void touch(Entity entity);
	
	public abstract Tileable clone();
	
	public void sendToView(TileView tileView) {
		tileView.accept(itemView);
	}
	
	public void removeFromView(TileView tileView) {
		tileView.remove(itemView);
	}
	
	public void acceptAvatar(Avatar avatar) {
		this.touch(avatar);
	}
	
	public void acceptAvatarInteraction(Avatar avatar) {}
}
