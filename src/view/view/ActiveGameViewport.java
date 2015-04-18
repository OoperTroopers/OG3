package view.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.List;

import controller.RunGame;

import model.entities.Avatar;
import model.entities.Entity;
import model.loadsave.FilePaths;
import model.loadsave.Load;
import model.map.Tile;
import utilities.TileAlgorithm;
import view.modelview.tileable.TileableView;
import view.tools.Constants;

@SuppressWarnings("serial")
public class ActiveGameViewport extends Viewport {
// adfskl;dfsakl;dfsakl;adfskl;dsfkl;dsafkl;adsfkl;sdafkl;dfsajkl;sdfakl;sdafjkl;adsfkl;asdfjklsdafkl;sadfkl;adskl;dsfkl;fdskl;sdfkl;asdfkl;dskl;dsakl;dsfkl;dfskl;sdfkl;sdkl;dfsakl;dskl;dsfkl;fdskl;dfskl;fdskl;dfsjkldfsakl;fsdakl;fdsakl;sadfkl;fdsal;dfsajklfadsjkladfsljkfadsjklsdfakl;afsdkl;adfskl;fsadkl;dfskl;dfsakl;dsfkl;dfsakl;fdsakl;fdsajklfdskl;dfsdfkls;akl;asdfkl;dsafkl;dfsaljkdfsakl;fsdakl;sdfakl;dfsakl;adfsjkldfsajkldfsaj;adsfkl;dsal;dfsakl;sdfajklfdsakl;dfsakl;dsfkl;sdafkl;dfsakl;sdfkl;kl;dfsakl;adfskl;jkldfsakl;sdfajklk;fdsakl;afdsjklkl;sadfkl;adfsjkll;adfskl;dfsakjklsadfjkldsfjklkl;afdjklfsadjkljklfads;fdsajklkl;afsdfdsjklk;fdsajklfadskl;kl;adfsjklsdfjkljklsadl;fasdkljkladfsjkldfskl;kl;fdsl;dfskl;adfls;kl;adsfjklkl;fdsakl;adfskl;dfsjklfdsjkldafs;adfskl;asdfklasdfklsadfadfsjkldfksajklfdsajkldfsajkladslkjdsalfsadfjkfdsa;kl;fsadjkldsjklafdskl;fadsjkdfjklsadfsjkldfsjkldsfjklfsdakl;dsafjklasdfkl;sadfkladfskldfsajkljklkl;klklfdsajkllafsdkl;dfsakljklfadsklfsdjkll;fadsjklfdsjkljklfdasjklkljdfjkldfsajklsdjkljlsadfjkljklfadsjkljklfdsajklkkl;adfsjkl;afsdjklkl;asdkl;adfsjkll;asdfkl;asdf;kl;dfskl;adfsklkl;afdskl;fadslkl;adfskl;fadskl;dfsakl;dfsajklfdsjklafsdlljkadfsfsdaklsdfaj;sdfjdfsl;fdsl;fsdjkldfsa;fdsakl;dfsjdfsajklsadfjklasdfkl;dfsajkldfsakl;adfsjkdfsakldfsajklafsdjkldfsajkadfsjkldfsakljdfsakl;dfsadfsajkldfsakjfadsk;fdsakjldfskl;dfsajkdfsakl;sadfjklfdsakl;fdsaljkdfsajklfsadjklsdfajkadsfjklfsadjkfsdajklfadsjkldfsajklsadfjkldsfajklsadjklfsdajkldfsajkldfsajklfsadkl;sdfaljkfdsakl;dfsajkldfsajklafsdjkldsfajkldfasjklsdfajklsfadkl;afsdjkldsfaladfskl;fdsaadfsjklfdsajkldfsal;dfsal;fdsaj;dfsajkfdsakl;fdsaljksadfkl;dfsajlkd
	
	Tile currentTile;
	// static HeartsViewport heartsViewport = HeartsViewport.getInstance();
	// static SimpleStatsViewport simpleStatsViewport = SimpleStatsViewport.getInstance();
	
	Load load = new Load();
	
	private static ActiveGameViewport activeGameViewport = 
			new ActiveGameViewport();

	public ActiveGameViewport() {
		this.setPreferredSize(new Dimension(Constants.GAME_VIEW_HEIGHT,Constants.GAME_VIEW_WIDTH));
		this.setBackground(Color.BLACK);
		
		// add other viewports
		// this.add(heartsViewport);
		// this.add(simpleStatsViewport);
		
		// get beginning tile
		try {load.read(FilePaths.DEFAULT);} 
		catch (IOException e) {e.printStackTrace();}
		currentTile = load.getBeginningTile();
		Entity avatar = new Avatar(currentTile);
		RunGame rg = new RunGame((Avatar) avatar);
	}
	
	@Override
	public void visit(ViewportStack viewportStack) {
		viewportStack.add(this);
	}
	
	public static ActiveGameViewport getInstance() {
		return activeGameViewport;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Point p;
		List<Tile> tiles = TileAlgorithm.getAllTiles(currentTile);
		for (Tile t : tiles) {
			p = TileAlgorithm.toPixel(t);
			
			for (TileableView tv : t.getTileableViews())
				g.drawImage(tv.getImage(), p.x, p.y, 
					Constants.TILE_HEIGHT, Constants.TILE_WIDTH, null);
		}
	}
}
