package view.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JPanel {
	
	public static View view = new View();
	private ViewportStack viewportStack = ViewportStack.getInstance();
	
	public View() {}
	
	public void render() {}
	
	public static View getInstance() {
		return view;
	}
	
	public void addViewport(Viewport viewport) {
		// this seems like it should work. idk. visitor pattern knock off?
		this.add(viewport);
		viewport.visit(viewportStack);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void stylize() {
		this.setBackground(Color.black);
	}

	public void addViewport(Viewport viewport, String borderLayout) {
		this.add(viewport, borderLayout);
		viewport.visit(viewportStack);
	}
}
