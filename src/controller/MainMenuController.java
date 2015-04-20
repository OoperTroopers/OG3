package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.view.MainMenuViewport;
import view.view.Viewport;

public class MainMenuController extends Controller {
	
	public Viewport view;
	
	public MainMenuController() {
		this.view = new MainMenuViewport(new NewGameListener(), new LoadGameListener(), new ExitGameListener());
	}
	
	public Viewport getViewport() {
		return this.view;
	}

	public class NewGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("NEW GAME");			
		}		
	}
	
	public class LoadGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("LOAD GAME");			
		}		
	}
	
	public class ExitGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("EXIT GAME");			
		}		
	}
}
