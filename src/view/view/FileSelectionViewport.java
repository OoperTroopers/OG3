package view.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FileSelectionViewport extends Viewport {
	
    String[] files;
	public FileSelectionViewport() {
        initComponents();
    }

    public FileSelectionViewport(String[] files) {
    	this.files = new String[files.length];
    	for(int i = 0; i < files.length; i++)
    		this.files[i] = files[i];
    	initComponents();
    }

	private void initComponents() {
    	try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");} 
    	catch (Exception e) { e.printStackTrace(); }
    	
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    	JLabel jlabel = new JLabel("Pick your file");
    	jlabel.setFont(new Font("Verdana",1,20));
    	jlabel.setPreferredSize(new Dimension(100,100));
        this.add(jlabel);
        
    	/*for (int i = 0; i < files.length; i++) {
    		String name = files[i].substring(0, files[i].length()-4);
	        JButton button = new JButton(name);
	        //button.addActionListener(new Listener(files[i]));
	        button.setFont(new Font(null));
	    	this.add(button);
    	}*/
    }
	
	public void addButton(JButton button) {
		this.add(button);
	}
	
    @Override
	void visit(ViewportStack viewportStack) {
		
	}
}
