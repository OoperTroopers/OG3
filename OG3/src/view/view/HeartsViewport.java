package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import view.tools.Constants;

@SuppressWarnings("serial")
public class HeartsViewport extends Viewport {
	public static HeartsViewport heartsViewport = new HeartsViewport();
	
	public HeartsViewport() {
		// this.setPreferredSize(new Dimension(Constants.HEART_VIEW_WIDTH, Constants.HEART_VIEW_HEIGHT));
		this.setPreferredSize(new Dimension(Constants.HEART_VIEW_WIDTH, Constants.HEART_VIEW_HEIGHT));
	}

	@Override
	void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
	
	public static HeartsViewport getInstance() {
		return heartsViewport;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, Constants.HEART_VIEW_WIDTH, Constants.HEART_VIEW_HEIGHT);
	}
}
