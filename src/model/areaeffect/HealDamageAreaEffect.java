package model.areaeffect;

import model.effects.Effect;
import model.map.Tile;
import view.modelview.areaeffect.HealDamageAreaEffectView;
import view.modelview.tile.TileView;

public class HealDamageAreaEffect extends AreaEffect {

	private static HealDamageAreaEffectView healDamageAreaEffectView = new HealDamageAreaEffectView();
	public HealDamageAreaEffect() {
		super(healDamageAreaEffectView);
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
