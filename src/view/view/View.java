package view.view;

import java.awt.Graphics;

import javax.swing.JPanel;
public class View extends JPanel {
	
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 700;

	// abstract out viewports later
	public static final int pHeight = 700;
	public static final int pWidth = 600;

	public View() {
	}

	public void render() {
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
