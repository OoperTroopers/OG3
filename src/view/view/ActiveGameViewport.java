package view.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.tools.Constants;
import view.tools.ViewPosition;

@SuppressWarnings("serial")
public class ActiveGameViewport extends Viewport {
	private static ActiveGameViewport activeGameViewport = 
			new ActiveGameViewport();

	public ActiveGameViewport() {
	}
	
	@Override
	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
	
	public static ActiveGameViewport getInstance() {
		return activeGameViewport;
	}
	
	public void draw(ImageIcon i) {
		System.out.println("drawing image");
		this.add(new JLabel(i));
	}
	
	public void draw(ImageIcon i, ViewPosition viewPosition) {
		System.out.println("drawing image");
		JLabel toDraw = new JLabel(i);
		toDraw.setBounds(viewPosition.getX(), viewPosition.getY(), 
				Constants.TILE_WIDTH, Constants.TILE_HEIGHT);
		this.add(toDraw);
	}

	/*public void draw(ImageIcon i, ViewPosition viewPosition) {
		System.out.println("drawing image at "+viewPosition.toString());
		// this.add(new JLabel(i),150,250,300,400);
	}*/
}
