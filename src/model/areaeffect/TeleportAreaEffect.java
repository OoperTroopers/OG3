package model.areaeffect;

import model.effects.Effect;
import view.modelview.areaeffect.TeleportAreaEffectView;
import view.modelview.tile.TileView;

public class TeleportAreaEffect extends AreaEffect {
	private static TeleportAreaEffectView teleportAreaEffectView = new TeleportAreaEffectView();
	
	public TeleportAreaEffect() {
		super(teleportAreaEffectView);
		// TODO Auto-generated constructor stub
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
	public void removeFromView(TileView tileView) {
		// TODO Auto-generated method stub

	}

}
