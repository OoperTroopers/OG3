package view.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.tools.ImagePaths;
import view.tools.ViewPosition;
import model.map.GrassTerrain;
import model.map.Tile;

public class ViewFrame extends JFrame {
	static View view;
	
	public ViewFrame() {
		view = View.getInstance();
		
		this.setSize(600,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		view.stylize();
		
		this.add(view);

	}
	
	public void addViewport(Viewport viewport) {
		System.out.println("Viewport added");
		view.addViewport(viewport);
	}
	
	public void initialize() {
		ActiveGameViewport game = ActiveGameViewport.getInstance();
		addViewport(game);
	}

	public static Component getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
