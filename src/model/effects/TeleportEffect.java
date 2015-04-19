package model.effects;

import model.entities.Entity;
import model.map.Tile;

public class TeleportEffect {
	public void visit(Entity entity, Tile newTile) {
		//entity.removeFromTile();
		newTile.addTileable(entity);
		entity.update(newTile);
	}
}
