package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import view.tools.Constants;

public class SimpleStatsViewport extends Viewport {
	public static SimpleStatsViewport simpleStatsViewport = new SimpleStatsViewport();
	
	public SimpleStatsViewport() {
		this.setPreferredSize(new Dimension(Constants.VIEW_WIDTH, Constants.HEART_VIEW_HEIGHT + 40));
		this.setBackground(Color.black);
	}

	@Override
	void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}

	public static SimpleStatsViewport getInstance() {
		return simpleStatsViewport;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.YELLOW);
		g.fillRect(10, 0, Constants.VIEW_WIDTH / 3, Constants.HEART_VIEW_HEIGHT);

		g.setColor(Color.orange);
		g.fillRect(Constants.VIEW_WIDTH / 3, 0, 2 * (Constants.VIEW_WIDTH / 3) - 10, Constants.HEART_VIEW_HEIGHT);

	
	}
}
