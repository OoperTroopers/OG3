package model.effects;

import java.util.TimerTask;

import model.entities.Avatar;
import model.entities.Entity;
import utilities.TileAlgorithm.Direction;

public class RiverEffect extends TimerTask {

	Direction direction;
	Avatar avatar;
	
	public RiverEffect(Direction direction, Avatar avatar) {
		this.direction = direction;
		this.avatar = avatar;
	}
	
	@Override
	public void run() {
		avatar.move(direction);
		cancel();
	}
}
