/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modelview.tileable.terrain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import view.tools.ImagePaths;

/**
 *
 * @author Doherty
 */
public class WaterTerrainView extends TerrainView {
    BufferedImage image;
	
    public WaterTerrainView() {
        try { image = ImageIO.read(new File(ImagePaths.WATER_TERRAIN));} 
        catch (IOException e) {}	
    }

    @Override
    public BufferedImage getImage() { return image; }
}
