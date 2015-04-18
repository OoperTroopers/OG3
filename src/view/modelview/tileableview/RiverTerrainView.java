/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modelview.tileableview;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import view.tools.ImagePaths;

/**
 *
 * @author Doherty
 */
public class RiverTerrainView extends TerrainView {
    BufferedImage image;
	
    public RiverTerrainView() {
        try { image = ImageIO.read(new File(ImagePaths.RIVER_TERRAIN));} 
        catch (IOException e) {}	
    }

    @Override
    public BufferedImage getImage() { return image; }
}
