package view.view;

public class SimpleStatsViewport extends Viewport {
	public static Viewport simpleStatsViewport = new SimpleStatsViewport();
	
	public SimpleStatsViewport() {}

	@Override
	void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
}
