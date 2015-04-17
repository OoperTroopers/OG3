package view.view;

public class SimpleStatsViewport extends Viewport {
	public SimpleStatsViewport() {}

	@Override
	void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
}
