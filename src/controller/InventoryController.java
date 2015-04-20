/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import model.entities.Avatar;
import model.inventory.Inventory;
import model.items.Item;
import model.items.TakeableItem;
import view.view.InventoryViewport;
import view.view.ItemButton;
import view.view.Viewport;

/**
 *
 * @author Doherty
 */
public class InventoryController extends Controller {
    
    private Viewport view;
    private Avatar avatar;
    private ArrayList<ItemButton> itemButtons;
    
    public InventoryController(Avatar avatar) {
        this.avatar = avatar;
        Inventory inv = avatar.getInventory();
        itemButtons = new ArrayList<ItemButton>();
        for (TakeableItem i : inv.getInventory()) {
            ItemButton ib = new ItemButton(i);
            ib.addActionListener(new GenericButtonListener(i, avatar, this, ib));
            ib.setSize(50, 50);
            itemButtons.add(ib);
        }
        
        view = new InventoryViewport(new BackListener(), itemButtons);
    }
    
    public void reload() {
        view = null;
        
    	Inventory inv = avatar.getInventory();
        itemButtons = new ArrayList<ItemButton>();
        for (TakeableItem i : inv.getInventory()) {
            ItemButton ib = new ItemButton(i);
            ib.addActionListener(new GenericButtonListener(i, avatar, this, ib));
            ib.setSize(50, 50);
            itemButtons.add(ib);
        }
        
        view = new InventoryViewport(new BackListener(), itemButtons);
    }
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller previous = GameController.getInstance().removeFromStack();
            GameController.getInstance().swapViews(previous);
        }        
    }
    
    private class GenericButtonListener implements ActionListener {

        private TakeableItem i;
        private Avatar avatar;
        private InventoryController inventoryController;
        ItemButton ib;
        
        public GenericButtonListener(TakeableItem i, Avatar avatar, 
        		InventoryController inventoryController, ItemButton ib) {
            this.i = i;
            this.avatar = avatar;
            this.inventoryController = inventoryController;
            this.ib = ib;
        }
                
        @Override
        public void actionPerformed(ActionEvent e) {
            // System.out.println(i.getName() + " button clicked");
        	i.getClickedByAvatar(avatar);
        	inventoryController.reload();
        	ib.setIcon(null);
        }
        
    }

    @Override
    public Viewport getViewport() {
        return view;
    }
    
    
    
}
