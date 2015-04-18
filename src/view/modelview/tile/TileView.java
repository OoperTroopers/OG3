package view.modelview.tile;

import java.util.ArrayList;
import java.util.List;

import view.modelview.tileable.TileableView;

public class TileView {
	private List<TileableView> tileableViews;
	public TileView() {
		tileableViews = new ArrayList<TileableView>();
	}
	
	public List<TileableView> getList() {
		return tileableViews;
	}

	public void accept(TileableView tileableView) {
		tileableViews.add(tileableView);
	}
	
	public void remove(TileableView tileableView) {
		tileableViews.remove(tileableView);
	}
}
