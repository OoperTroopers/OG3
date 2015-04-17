package view.view;

public class HeartsViewport extends Viewport {
	public static Viewport heartsViewport = new HeartsViewport();
	
	public HeartsViewport() {}

	@Override
	void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
}
