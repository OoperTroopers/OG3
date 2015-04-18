// this is just a driver to run the view
// until we have a controller to do that

package view.tools;

import javax.swing.SwingUtilities;
import view.view.ViewFrame;

public class Driver {
	
	static ViewFrame vf;
	
	public static void main(String[] args) {
		Driver game = new Driver();
	}
	
	public Driver() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){ createAndShowGui(); }
		});
	}
	
	public static void createAndShowGui() {
		vf = new ViewFrame();
		vf.initialize();
	}
}
