package controller;

import model.entities.Avatar;

public class AvatarBrain extends Brain{

	Avatar myAvatar;
	private boolean hasMoved;
	
	public AvatarBrain(Avatar a){
		myAvatar = a;
		HiveMind.getInstance().addRunnable(this, 10);
	}
	
	
	@Override
	public void run(){
		myAvatar.refreshView();
		hasMoved = false;
	}
	
	public void hasMoved(){
		hasMoved=true;
	}
}
