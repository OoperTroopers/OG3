package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import view.view.FileSelectionViewport;
import view.view.Viewport;

public class FileController extends Controller {

	private FileSelectionViewport view;
	String[] fileStrings;
	List<JButton> buttons;
	
	public FileController() {		
		File folder = new File("files/");
		File[] listOfFiles = folder.listFiles();
		fileStrings = new String[listOfFiles.length];
	    for (int i = 0; i < listOfFiles.length; i++)
	      if (listOfFiles[i].isFile())
	        fileStrings[i] = listOfFiles[i].getName();
	    
		this.view = new FileSelectionViewport(fileStrings);
		buttons = new ArrayList<JButton>();
		createButtonsAndListeners();	    
		sendButtons();
	}
	
	private void sendButtons() {
		for (JButton button : buttons) {
			view.addButton(button);
		}
	}

	public void createButtonsAndListeners() {
		for (String file : fileStrings) {
			String name = file.substring(0, file.length()-4);
	        JButton button = new JButton(name);
	        Listener listener = new Listener(file);
	        button.addActionListener(listener);
	        buttons.add(button);
		}
	}
	
	
	
	@Override
	public Viewport getViewport() {
		return this.view;
	}
	
    class Listener implements ActionListener{
    	String filename;
    	public Listener(String filename) {
    		this.filename = filename;
    	}
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	System.out.println("You clicked "+filename);
        }
    }
}
