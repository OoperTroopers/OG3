package controller;

import javax.swing.JFrame;

import view.view.ViewFrame;
import view.view.Viewport;

public class GameController {

	private Viewport activeViewport;
	private Controller activeController;
	private JFrame frame;
	
	public GameController() {
		this.frame = new JFrame();
		this.frame.setExtendedState(this.frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.activeController = new MainMenuController();
		this.activeViewport = this.activeController.getViewport();
		this.frame.add(this.activeViewport);
		this.frame.setVisible(true);
	}

}
