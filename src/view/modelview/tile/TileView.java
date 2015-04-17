package view.modelview.tile;

import java.util.ArrayList;
import java.util.List;

import view.modelview.tileable.TileableView;

public class TileView {
	private List<TileableView> tileableViews;
	public TileView() {
		tileableViews = new ArrayList<TileableView>();
	}
	
	public void remove(TileableView tileableView) {
		
	}
	
	public List<TileableView> getList() {
		return tileableViews;
	}
}
