package model.areaeffect;

import model.effects.Effect;
import view.modelview.areaeffect.TrapAreaEffectView;
import view.modelview.tile.TileView;

public class TrapAreaEffect extends AreaEffect {
	private static TrapAreaEffectView trapAreaEffectView = new TrapAreaEffectView();
	
	public TrapAreaEffect() {
		super(trapAreaEffectView);
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
