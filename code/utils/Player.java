package utils;

import data.*;
import java.util.ArrayList;

public class Player {
    //initalizing our 
    private String playerName;
    private int HP;
    private ArrayList<String> inventory = new ArrayList<>();
    
    //adds the restored hp ammount to the player object's HP
    public void restoreHP(int he){
        HP = HP +he;

    }
    //subtracts the damage dealt from the player object's HP
    public void damageHP(int dam){
        HP = HP - dam;

    }
    //assign an ammount to initalize player object's HP
    public void setHP(int hp){
        HP = hp;

    }
    //return the HP of the player character
    public int getHP(){
        return HP;

    }

    public void setPlayerName(String n){
        playerName = n;

    }
    public String getPlayerName(){
        return playerName;

    }

    public void inventoryAdd(String item){

        inventory.add(item);
    }
    public boolean hasItem(boolean item){
        
        return inventory.contains(item);
    }
    public String returnInventory(){
        String printInv = null;
        for (String item : inventory) {
            printInv = printInv +" | " + item ;
        }
        return printInv;
    }

    public Weapon currentWeapon;
    
}
