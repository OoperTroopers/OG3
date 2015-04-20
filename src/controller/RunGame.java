package controller;

import javax.swing.SwingUtilities;

import view.view.ActiveGameViewport;
import view.view.ViewFrame;

public class RunGame {
	public static void main(String[] args) {
                RunGame game = new RunGame();
	}
	
	public RunGame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){ createAndShowGui(); }
		});
	}
	
	public static void createAndShowGui() {
		// ViewFrame vf = ViewFrame.getInstance();
		// vf.initialize();
		GameController gameController = GameController.getInstance();
		// gameController.swapViews(new GameController());
	}
}
