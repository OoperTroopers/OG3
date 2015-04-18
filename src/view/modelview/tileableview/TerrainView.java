package view.modelview.tileableview;

import view.modelview.tileable.TileableView;


public abstract class TerrainView implements TileableView {
    @Override
    public int getPriority() { return 1; }
}
