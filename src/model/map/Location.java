/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

/**
 * The purpose of Location is to store (and allow for changing of) 
 * the position of a map object.
 * @author Jason Owens, Cormac McCarthy
 */
public class Location {
    private int x;
    private int y;
    private int z;
    
    public Location() {
    	
    }
    
    public Location(int x, int y, int z) {
    	this.x = x;
    	this.y = y;
    	this.z = z;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
    
    public int getZ() {
    	return this.z;
    }
    
    public String toString() {
    	return "{" + this.x + ", " + this.y + ", " + this.z + "}";
    }
    
    public int hashCode() {
    	return 92821 * x + 7243 * y + 11317 * z;
    }
    
    public Location clone(){
        return new Location(this.x, this.y, this.z);
    }
}
