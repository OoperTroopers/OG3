package view.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.tools.Constants;
import view.tools.ImagePaths;
import view.tools.ViewPosition;

@SuppressWarnings("serial")
public class ActiveGameViewport extends Viewport {
	private static ActiveGameViewport activeGameViewport = 
			new ActiveGameViewport();

	public ActiveGameViewport() {
		this.setPreferredSize(new Dimension(300,400));
		this.setBackground(Color.BLACK);
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
		System.out.println("drawing image W ViewPosition");
		JLabel toDraw = new JLabel(i);
		System.out.println("\nBounds are ("+viewPosition.getX()+", "+viewPosition.getY()+")\n");
		toDraw.setBounds(viewPosition.getX(), viewPosition.getY(), 
				Constants.TILE_WIDTH, Constants.TILE_HEIGHT);
		this.setAlignmentX(0);
		System.out.println("Container bounds are ("+this.getAlignmentX()+", "+this.getAlignmentY()+")");
		this.add(toDraw);
	}
	
	public void draw(Image i, int x, int y, int height, int width) {
		Graphics g = View.getInstance().getGraphics();
		System.out.println("Draw 1");
		g.drawImage(i, x, y, x+height, y+width, null);
		g.finalize();
		System.out.println("Draw 2");
	}
}
