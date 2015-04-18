package model.areaeffect;

import model.effects.Effect;
import model.map.Tile;
import view.modelview.areaeffect.HealDamageEffectView;

public class HealDamageEffect extends AreaEffect {

	private static HealDamageEffectView healDamageEffectView = new HealDamageEffectView();
	public HealDamageEffect() {
		super(healDamageEffectView);
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

}
