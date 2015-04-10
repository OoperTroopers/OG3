/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.map;

/**
 * The purpose of Location is to store (and allow for changing of) 
 * the position of a map object.
 * @author Jason Owens
 */
public class Location {
    private int q;
    private int r;
    public Location(){
        q=0;
        r=0;
    }
    public Location(int q, int r){
        this.q=q;
        this.r=r;
    }
    
    public int getQ(){
        return q;
    }
    public int getR(){
        return r;
    }
    public void setQ(int q){
        this.q = q;
    }
    public void setR(int r){
        this.r = r;
    }
    
    public Location clone(){
        return new Location(q,r);
    }
}
