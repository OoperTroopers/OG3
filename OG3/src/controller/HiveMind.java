package controller;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import model.entities.NPC;

public class  HiveMind {
	private static HiveMind me;
	
	
	private Timer timer;
	private ArrayList<Brain> brains;
	
	public HiveMind(){
		timer = new Timer();
	}
	
	public static HiveMind getInstance(){
		if(me == null){
			me = new HiveMind();
		}
		return me;
	}
	
	public void addRunnable(TimerTask t, int timeInMilliseconds){
		//timer.schedule(t, timeInMilliseconds);
		timer.scheduleAtFixedRate(t, 0, timeInMilliseconds);
	}
	
}
