/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modelview.viewhelpers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import view.modelview.tileable.items.ItemView;

/**
 *
 * @author Doherty
 */
public class InventoryView {
    private ArrayList<ItemView> itemView;
    
    public InventoryView() {
        itemView = new ArrayList<>(1);
    }
    
    public ArrayList<BufferedImage> getItemView() { 
        ArrayList<BufferedImage> bi = new ArrayList<>(1);
        for (ItemView i : itemView) {
            bi.add(i.getImage());
        }
        return bi;
    }   
    
    public void add(ItemView iv) {
        itemView.add(iv);
    }
    
    public void remove(ItemView iv) {
        itemView.remove(iv);
    }
}
