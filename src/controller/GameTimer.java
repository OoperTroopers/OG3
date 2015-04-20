package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import model.entities.NPC;

public class  GameTimer {
	private static GameTimer me;
	
	private Timer timer;
	private ArrayList<Brain> brains;
	
	public GameTimer(){
		timer = new Timer();
	}
	
	public static GameTimer getInstance(){
		if(me == null){
			me = new GameTimer();
		}
		return me;
	}
	
	public void addRunnable(TimerTask t, int timeInMilliseconds){
		//timer.schedule(t, timeInMilliseconds);
		//  this is one time
		
		timer.scheduleAtFixedRate(t, 0, timeInMilliseconds);
		//  this is repeatedly
	}
	
	
	
	// things that might use GameTimer....
	// 
	// 1. npc movement
	// 2. projectiles
	// 3. poison effects
	//
	
}
