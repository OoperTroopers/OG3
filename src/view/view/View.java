package view.view;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JPanel {
	
	public static View view = new View();
	private ViewportStack viewportStack;
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 700;

	// abstract out viewports later
	public static final int pHeight = 700;
	public static final int pWidth = 600;

	public View() {
		
	}

	public void render() {}
	
	public static View getInstance() {
		return view;
	}
	
	public void addViewport(Viewport viewport) {
		// this seems like it should work. idk. visitor pattern knock off?
		// viewportStack.add(viewport);
		viewport.visit(viewportStack);
	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
