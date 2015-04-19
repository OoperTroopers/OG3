package model.areaeffect;

import model.effects.Effect;
import model.map.Tile;
import view.modelview.areaeffect.InstantDeathAreaEffectView;
import view.modelview.tile.TileView;

public class InstantDeathAreaEffect extends AreaEffect{

	private static InstantDeathAreaEffectView instantDeathAreaEffectView = new InstantDeathAreaEffectView();

	public InstantDeathAreaEffect() {
		super(instantDeathAreaEffectView);
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

	}

}
