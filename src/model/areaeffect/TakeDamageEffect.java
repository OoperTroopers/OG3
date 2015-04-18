package model.areaeffect;

import model.effects.Effect;
import view.modelview.areaeffect.TakeDamageEffectView;
import view.modelview.tile.TileView;

public class TakeDamageEffect extends AreaEffect {

	private static TakeDamageEffectView takeDamageEffectView = new TakeDamageEffectView();
	
	public TakeDamageEffect() {
		super(takeDamageEffectView);
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
