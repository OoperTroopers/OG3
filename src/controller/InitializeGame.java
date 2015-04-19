package controller;

import javax.swing.SwingUtilities;
import view.view.ViewFrame;

public class InitializeGame {
	public static void main(String[] args) {
		InitializeGame game = new InitializeGame();
	}
	
	public InitializeGame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){ createAndShowGui(); }
		});
	}
	
	public static void createAndShowGui() {
		ViewFrame vf = new ViewFrame();
		vf.initialize();
	}
}