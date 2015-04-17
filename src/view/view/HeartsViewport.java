package view.view;

public class HeartsViewport extends Viewport {
	public HeartsViewport() {}

	@Override
	void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
}
