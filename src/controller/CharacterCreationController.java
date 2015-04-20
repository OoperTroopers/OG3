package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Avatar;
import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;
import model.occupations.SmasherOccupation;
import model.occupations.SneakOccupation;
import model.occupations.SummonerOccupation;

import view.view.Viewport;

public class CharacterCreationController extends Controller {
	
	private Viewport view;
	
	public CharacterCreationController() {
		
	}
	
	public class SmasherListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Load loadObject = new Load();
			try {
				loadObject.read(FilePaths.DEFAULT);
			} catch (Exception ex) {}
			Tile startingTile = loadObject.getBeginningTile();
			Avatar avatar = new Avatar(startingTile, new SmasherOccupation());
			System.out.println("CREATED SMASHER");
		}		
	}
	
	public class SneakListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Load loadObject = new Load();
			try {
				loadObject.read(FilePaths.DEFAULT);
			} catch (Exception ex) {}
			Tile startingTile = loadObject.getBeginningTile();
			Avatar avatar = new Avatar(startingTile, new SneakOccupation());
			System.out.println("CREATED SNEAK");
		}		
	}
	
	public class SummonerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Load loadObject = new Load();
			try {
				loadObject.read(FilePaths.DEFAULT);
			} catch (Exception ex) {}
			Tile startingTile = loadObject.getBeginningTile();
			Avatar avatar = new Avatar(startingTile, new SummonerOccupation());
			System.out.println("CREATED SUMMONER");
		}		
	}
	
	public Viewport getViewport() {
		return this.view;
	}

}
