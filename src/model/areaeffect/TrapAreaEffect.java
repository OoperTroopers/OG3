package model.areaeffect;

import model.effects.Effect;
import model.effects.TrapEffect;
import view.modelview.areaeffect.TrapAreaEffectView;
import view.modelview.tile.TileView;

public class TrapAreaEffect extends AreaEffect {
	private static TrapAreaEffectView trapAreaEffectView = new TrapAreaEffectView();
	private Effect effect;
	
	public TrapAreaEffect() {
		super(trapAreaEffectView);
		this.effect = new TrapEffect();
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

}
