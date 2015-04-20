package controller;

import javax.swing.JFrame;
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
	
	public void swapViews(Controller c) {
		Viewport v = c.getViewport();
		this.frame.remove(activeViewport);
		activeViewport = v;
		activeController = c;
		this.frame.add(activeViewport);
	}
}
