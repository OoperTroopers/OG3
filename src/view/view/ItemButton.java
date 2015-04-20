/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.view;

import java.awt.image.BufferedImage;
import javax.swing.JButton;
import model.items.Item;

/**
 *
 * @author Doherty
 */
public class ItemButton extends JButton {
    private Item i;
    private String toolTipText;

    public ItemButton(Item i) {
        this.i = i;
        toolTipText = i.getName();
    }

    public Item getItem() {
        return i;
    }
    
    public BufferedImage getImage() {
        return i.getItemView().getImage();
    }
    
    public String getToolTip() {
        return toolTipText;
    }
          
}
