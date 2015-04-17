package view.view;

public class ActiveGameViewport extends Viewport {

	@Override
	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}


}
