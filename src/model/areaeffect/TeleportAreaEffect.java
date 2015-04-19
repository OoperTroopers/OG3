package model.areaeffect;

import model.effects.Effect;
import model.effects.TeleportEffect;
import model.entities.Entity;
import model.map.Tile;
import view.modelview.areaeffect.TeleportAreaEffectView;
import view.modelview.tile.TileView;

public class TeleportAreaEffect extends AreaEffect {
	private static TeleportAreaEffectView teleportAreaEffectView = new TeleportAreaEffectView();
	private TeleportEffect effect;
	private Tile destination;
	
	public TeleportAreaEffect(Tile destination) {
		super(teleportAreaEffectView);
		this.effect = new TeleportEffect();
		this.destination = destination;
	}

	@Override
	public void acceptEffect(Effect e) {
		e.visit(this);
	}

	@Override
	public boolean isTraversable() {
		return true;
	}

	@Override
	public void removeFromView(TileView tileView) {
		// TODO Auto-generated method stub

	}
	
	public void activate(Entity entity) {
		effect.visit(entity, destination);
	}
}
