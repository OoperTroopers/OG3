package model.effects;

import view.view.ActiveGameViewport;
import model.entities.Entity;
import model.map.Tile;

public class TeleportEffect {
	public void visit(Entity entity, Tile newTile) {
		entity.getTile().removeTileable(entity);
		entity.setTile(newTile);
		entity.update(newTile);
		ActiveGameViewport.getInstance().activateAvatarTile();
		newTile.addTileable(entity);
		entity.onMove();		
	}
}
