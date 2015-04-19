package view.view;

import javax.swing.JPanel;

public abstract class Viewport extends JPanel {

	abstract void visit(ViewportStack viewportStack);
	// abstract static Viewport getInstance();
}
