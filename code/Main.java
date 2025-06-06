import data.*;
import java.util.Scanner;
import utils.*;

public class Main{ 
    //initializing the variables we will use throughout the code
    public static boolean gameRunning =  false;
    public static Player playerOne;
    private static Scanner myInput;


    //Game initalization with intro script and character creation
    private static void gameStart(){

        myInput = new Scanner(System.in);
        playerOne =  new Player();
        playerOne.setHP(100);

        //text block with game intro
        System.out.println("""
                           ============= Welcome to the Treasure in the Deep =============\r
                           \r
                           Whilst on a journey to find The Hidden Treasure of Pirates Past, \r
                           a storm shipwrecks your vessel into jagged rocks, and you are \r
                           thrown overboard. Now waking up on a nearby beach, can you get \r
                           back onto the ocean and complete your quest?\r
                           \r
                           ================================================================""");
        
        //ask user for their player name ands assigning it to pay object
        System.out.print("'ay there what be yer name? ");
        String name = myInput.nextLine();
        playerOne.setPlayerName(name);
        System.out.println("I see. so yer name be "+ playerOne.getPlayerName()+"");

        //text block setup for 
        System.out.println("""
                           Rummagin' through the sand at yer feet, ye feel a slight protrusion.\r
                           It be yer trusty weapon. But what form does this here weapon take? \r
                           """);
        //assigning weapon choice to null so we can enter our input check loop
        String weaponChoice=null;

        //ensure the user picks one of our 2 inputs and look the request until its fulfilled correctly
        while (!"D".equalsIgnoreCase(weaponChoice) && !"F".equalsIgnoreCase(weaponChoice)){ 
            System.out.println("An unreliable and rusty [F]lintlock or a dull but sturdy [D]agger: ");
            weaponChoice = myInput.next();
            
        }

        //switch case depending on the users input above
        switch(weaponChoice.toUpperCase()){
            case "D":
                playerOne.currentWeapon = new WeaponDagger();
                System.out.println("Of course its the " + playerOne.currentWeapon.name + " that slots into your ankle strap!");
                break;
            case "F":
                playerOne.currentWeapon = new WeaponFlintlock();
                System.out.println("Of course its the "+ playerOne.currentWeapon.name +" you keep in your hip holster!");
                break;
        
        }
        System.out.println("=================== Now your journey begins! ===================");

        playerOne.setX(0);
        playerOne.setY(0);
        //set game to now be running and start main loop
        gameRunning = true;
        
        
    }

    public static void main(String[] args){
        //calling the game start method to begin
        gameStart();

        //while the boolean is true the game will keep going unless it ends by quitting or losing all your hp
        while (gameRunning) { 
                
            System.out.println("Games on");
            Map.initalizeMaps();
            MapManager mapManager = new MapManager(playerOne);
            mapManager.start();
            
            break;
            
        }
    }

}
