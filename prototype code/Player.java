import java.util.ArrayList;
import data.*;

public class Player {

    private String playerName;
    private int HP;
    private ArrayList<String> inventory = new ArrayList<>();
    

    public void restoreHP(int he){
        HP = HP +he;

    }
    public void damageHP(int dam){
        HP = HP - dam;

    }
    public void setHP(int hp){
        HP = hp;

    }
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
