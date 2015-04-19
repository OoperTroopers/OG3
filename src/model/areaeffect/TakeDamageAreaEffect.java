package model.areaeffect;

import model.effects.Effect;
import view.modelview.areaeffect.TakeDamageAreaEffectView;
import view.modelview.tile.TileView;

public class TakeDamageAreaEffect extends AreaEffect {

	private static TakeDamageAreaEffectView takeDamageAreaEffectView = new TakeDamageAreaEffectView();
	
	public TakeDamageAreaEffect() {
		super(takeDamageAreaEffectView);
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
