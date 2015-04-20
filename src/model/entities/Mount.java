package model.entities;

import utilities.TileAlgorithm.Direction;
import view.modelview.tile.TileView;
import view.modelview.tileable.TileableView;
import view.modelview.tileable.entities.MountView;
import view.view.ActiveGameViewport;
import controller.ControllerAvatar;
import model.equipmentmanagers.MountEquipmentManager;
import model.map.Tile;
import model.occupations.MountOccupation;
import model.statistics.MountStatistics;

public class Mount extends NPC {
	private Avatar avatar;
	private MountView mountView;
	
	public Mount(){
		super(new MountOccupation(), new MountEquipmentManager(), new MountStatistics(), true);
		this.mountView = new MountView();
	}
	
	public Mount(MountView mountView) {
		super(new MountOccupation(), new MountEquipmentManager(), new MountStatistics(), true);
		this.mountView = mountView;
	}
	
	@Override
	public void acceptAvatar(Avatar avatar) {	
		/*if (this.avatar != null) return;
		this.avatar = avatar;
		this.avatar.increaseRadiusOfVision(2);
		avatar.acceptMount(this);*/
	}
	
	@Override
	public void acceptAvatarInteraction(Avatar avatar) {
		if (this.avatar != null) return;
		this.avatar = avatar;
		this.avatar.increaseRadiusOfVision(2);
		mountView.togglePriority();
		avatar.acceptMount(this);
		
		// Tile tile = getTile();
		// tile.updateTileView();
	}
	
	public void unmount(){
		this.avatar.decreaseRadiusOfVision(2);
		avatar = null;
	}
	
	public void sendToView(TileView tileView) {
		tileView.accept(mountView);
	}

	public void removeFromView(TileView tileView) {
		tileView.remove(mountView);
	}
	
	@Override 
	public void update(Tile tile) {
		System.out.println("update in mount called");
		ActiveGameViewport.getInstance().setAvatarTile(tile);
	}
	
	@Override
	public boolean isTraversable() { return true; }

	public void updatePosition(Tile tile) {}
}
