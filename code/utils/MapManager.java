package utils;

import data.*;
import java.util.Random;
import java.util.Scanner;
public class MapManager {
    private Player player;
    private Scanner scanner;
    private boolean tankardCheck = false;
    public boolean done =false;

    public MapManager(Player player) {
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Enter [N/S/E/W] for movement, [Talk] for interacting with a NPC, [Inv] for checking contents of inventory, or [Quit] for closing the game.");
        while (true) {
            System.out.print("Order: ");
            String cmd = scanner.nextLine().trim().toLowerCase();

            if (cmd.equals("quit")) {
                break;
            } else if (cmd.equals("talk")) {
                handleTalk();
            } else if (cmd.equals("inv")) {
                handleInv();
            } else if (cmd.length() == 1 && "wens".contains(cmd)) {
                handleMove(cmd);
            } else {
                System.out.println("Invalid order, please enter N/S/E/W, talk, inv, quit.");
            }
        }
        System.out.println("Game Exited");
    }

    private void handleTalk() {
        //Get the shovel form old man.
        if (player.getX() == 0 && player.getY() == 2) {
            if (!player.hasItem("Shovel")) {
                player.addItem(new Item("Shovel"));
                System.out.println("""
                                   ========================= Old Mariner =========================\r
                                   Blimey, she\u2019s gonna make me walk the plank fer this. Wait, can \r
                                   ye help me find me amulet. I\u2019ll give ye me trusty shovel. I lost \r
                                   me amulet somewhere on dis here coastline, when I went fer a \r
                                   walk. If ya can find me amulet, I\u2019ll let ye use me ship.\r
                                   \r
                                   You take the Shovel from the Old Mariner.\r
                                   ================================================================""");
            } else if (player.hasItem("Shovel")&&!player.hasItem("Amulet")){
                System.out.println("""
                                   ========================= Old Mariner =========================\r
                                   Aye matey. Do ye have mi amulet? Hark ye fool! I learned ye, I's \r
                                   lost it on the coastline already. Fetch it for me and I'll let\r
                                   yer captain me ship.\r
                                   ================================================================""" //
                //
                //
                //
                );
            }
        } else {
            System.out.println("Looks like there isn't anyone to talk talk to here.\nJust you and your thoughts..");

        }
    }

    private void handleMove(String dir) {
        int newX = player.getX();
        int newY = player.getY();

        switch (dir) {
            case "w":
                newX--;
                break;
            case "e":
                newX++;
                break;
            case "n":
                newY++;
                break;
            case "s":
                newY--;
                break;
            default:
                break;
        }
        //Preventing out-of-map range
        if (newX < 0 || newX >= Map.X || newY < 0 || newY >= Map.Y) {
            System.out.println("""
                               The mystical fog bounces you back strangely denying you access to\r
                               this area.""" //
            );
            return;
        }

        //Detect whether the player has a boat, otherwise cannot enter the ocean
        if (Map.needsBoat(newX, newY) && !player.hasItem("Boat")) {
            if (player.getY()==0){
                System.out.println("""
                                   You step out You step out into the surf letting the waves lap at your toes.\r
                                   It looks rough out there, you're going to need a boat.""");
            } else if(newX == 3 && newY == 3){
                System.out.println("""
                                   You bang on the cave wall but you can't pass through. Maybe try\r
                                   another direction.""");
            }
            return;
        }

        //(4,2) Entering cave + boat removal and spyglass check
        if (newX == 4 && newY == 2){
            if (player.hasItem("SpyGlass")) {
                System.out.println("""
                                   You place the Spyglass into the hole in the wall, and as you push the Spyglass in the door slowly opens with a spring mechanism. \r
                                   \r
                                   After opening the door enough, you dart through the opening. However, the door shuts loudly behind you, preventing you from going back.""" //
                //
                );
                player.removeItem("Boat");
            } else {
                System.out.println("Trying finding a treasure to access this cave");
                return;
            }
            
        }

        //Detect whether the player has a boat, otherwise cannot enter the cave
        if (Map.needsSpyGlass(newX, newY) && player.hasItem("Boat")){
            if (player.getX() == 3 && player.getY() == 2) {
                return;
            }else if (newY==3){
                System.out.println("""
                                   If you travel any further in this direction you will crash your \r
                                   ship into the rocky cliff. Try another way""" //
                );
            }
            return;

        }

        // (1,4)Communicate with pirate ships and merchant ships
        if (newX == 1 && newY == 4) {

            System.out.println("You have been thrust into battle with a gang of pirates stalking this merchant vessle.\nYou walk the gangplank and board their ship through the fire of cannon balls and are met with a challenger");
            
            
            Player deckHand = new Player();
            deckHand.setHP(30);
            deckHand.setPlayerName("Deck Hand");
            deckHand.currentWeapon = new WeaponDagger();
            if (done){
                System.out.println("already fought the pirates");
                return;
            }
            while(deckHand.getHP()>=0){
                String input = null;
                while (!"A".equalsIgnoreCase(input) && !"H".equalsIgnoreCase(input) ){
                    System.out.printf("What will you do? %n [A]ttack or [H]eal : ");
                    input = scanner.next();
        
                }
                switch(input.toUpperCase()){
                    case "A":
                        System.out.println("Attacking");
                        //Call damage method
                        damage(player,deckHand);
                        break;

                    case "H":
                        System.out.println("Healing");
                        //Call Healing method
                        heal(player);
                        break;
                }
                damage(deckHand,player);
                if(player.getHP()>=0){
                    System.out.println("you have died whilst in combat");
                    System.exit(0);;
                }
            }

            System.out.println("You defeated the Deck Hand but just before you could catch your breath another challenger approaches");

            Player pirateCaptain = new Player();
            pirateCaptain.setHP(50);
            pirateCaptain.setPlayerName("Pirate Captain");
            pirateCaptain.currentWeapon = new WeaponCutlass();

            while(pirateCaptain.getHP()>=0){
                String input = null;
                while (!"A".equalsIgnoreCase(input) && !"H".equalsIgnoreCase(input) ){
                    System.out.printf("What will you do? %n [A]ttack or [H]eal : ");
                    input = scanner.next();
        
                }
                switch(input.toUpperCase()){
                    case "A":
                        System.out.println("Attacking");
                        //Call damage method
                        damage(player,pirateCaptain);
                        break;

                    case "H":
                        System.out.println("Healing");
                        //Call Healing method
                        heal(player);
                        break;
                }
                damage(pirateCaptain,player);
                if(player.getHP()>=0){
                    System.out.println("you have died whilst in combat");
                    System.exit(0);
                }
            }
            done =true;
            System.out.println("Merchant: Thank you for saving me here take this and maybe you can find a sunken treasure");
            System.out.println("You got the diving gear");
            System.out.println("Merchant: Also why dont you pickup one of that captains Cutlass while you are here its better than that " + player.currentWeapon.name );
            player.currentWeapon = new WeaponCutlass();
            player.addItem(new Item("Diving Gear"));

        }

        //getting tankard
        if (newX == 4 && newY == 3) {
            if(!player.hasItem("Tankard")){
                player.addItem(new Item("Tankard"));
                System.out.println("You recieved the tankard");
            }

        }

        if (newX == 4 && newY == 4){

            if (!tankardCheck){
                System.out.println("There must be some kind of secret in here to open this doorway");
                return;
            }else{

            Player boss = new Player();
            boss.setHP(150);
            boss.setPlayerName("The Kraken");
            boss.currentWeapon = new WeaponTentacle();

            while(boss.getHP()>=0){
                String input = null;
                while (!"A".equalsIgnoreCase(input) && !"H".equalsIgnoreCase(input) ){
                    System.out.printf("What will you do? %n [A]ttack or [H]eal : ");
                    input = scanner.next();
        
                }
                switch(input.toUpperCase()){
                    case "A":
                        System.out.println("you're now Attacking");
                        //Call damage method
                        damage(player,boss);
                        break;

                    case "H":
                        System.out.println("you are now Healing");
                        //Call Healing method
                        heal(player);
                        break;
                }
                damage(boss,player);
                if(player.getHP()>=0){
                    System.out.println("You are grabbed by the kraken, it throws you into the far West wall, and you land in a pile of skeletons, you die… GAME OVER");
                    System.exit(0);
                }
            }
            System.out.println("Now that the kraken has been defeated, you are free to take as much gold as you wish. If only you could find a way out. \r\n" + //
                                "\r\n" + //
                                "THE END ");
            System.exit(0);

            }
        }

        //Calculating the player's position
        player.setX(newX);
        player.setY(newY);
        System.out.println("Now position: (" + newX + "," + newY + ") \n" + Map.getName(newX, newY));
        System.out.println(Map.getDescs(newX, newY));
    }
    public static void damage(Player AttackingPlayer, Player DefendingPlayer){
            Boolean didMiss = Miss(AttackingPlayer.currentWeapon.accuracy);
            if (didMiss == true){

                System.out.println("You missed");

            }
            else{
    
                Random rand =  new Random();
                int damage = rand.nextInt(AttackingPlayer.currentWeapon.damageMin,AttackingPlayer.currentWeapon.damageMax);
                DefendingPlayer.damageHP(damage);
            
                int currentHP = DefendingPlayer.getHP();
                String name = DefendingPlayer.getPlayerName();
                System.out.printf(" %s %s their %s and dealt %d damage to %s%n",AttackingPlayer.getPlayerName(),AttackingPlayer.currentWeapon.verb,AttackingPlayer.currentWeapon.name, damage,name);
            
                System.out.println(currentHP + " HP");
    
            }
    }
    public static boolean Miss(int accuracy){
    
        boolean didMiss = false;        
        //Miss chance random object.
        Random rand =  new Random();
        int missChance = rand.nextInt(1,accuracy);
        
        //Tell out boolean if the miss is true or false
        if (missChance == 1){
    
            didMiss = true;
        
        }
        //return the value of the miss
        return didMiss;
    }
    public static void heal(Player NewPlayer){
            //put here check if the health potion counter in the inventory is empty
            Random rand =  new Random();
            int heal = rand.nextInt(0,10);
            NewPlayer.restoreHP(heal);
            int currentHP = NewPlayer.getHP();
    
            System.out.println("You healed yourself for "+heal+" HP. your new HP is:"+currentHP);
            
    }
    private void handleInv(){

        player.showInventory();
        if (!player.invEmpty()){
            String choice = "";
            while (true){ 
                System.out.println("What Item would you like to use: ");
                choice = scanner.nextLine();
                if (choice.contains("shovel")||choice.contains("amulet") ||choice.contains("diving gear")||choice.contains("tankard")||choice.contains("spyglass")){
                    break;
                }
            }
            switch(choice.toLowerCase()){

                case "shovel":
                    if (player.getX() == 0 && player.getY() == 2){

                        System.out.println("""
                                       As you take out your shovel, you hear a guard in the distance \r
                                       scream \u201cNO DIGGING\u201d.""" //
                        );

                    } else if (player.getX() == 0 && player.getY() == 1) {

                        System.out.println("You dig and dig, nothing but sand.");
                
                    } else if (player.getX() == 0 && player.getY() == 0){

                        System.out.println("""
                                       As you puncture the sand and lift the first pile away with your \r
                                       shovel, you notice a gold amulet glistening in the sun.  \r
                                       \r
                                       The Amulet has been added to your inventory.""");
                        player.addItem(new Item("Amulet"));

                    } else {
                        System.out.println("""
                                       you bring out the shovel raising it into the air to strike the\r
                                       ground beneath you. But you lose the confidence.""");
                    }
                    return;

                case "amulet":
                    System.out.println("""
                                   You look at the shiny necklace in your hands. It's giant gemstone\r
                                   gleams in a ray of light. You ca see why the Old Mariner wanted\r
                                   to get it back.""");

                    break;

                case "diving gear":
                    if (player.getX() == 2 && player.getY() == 0){

                        System.out.println("""
                                           You dive under the water and swim down to the sunken ship. As you look through the rubble you find something. \r
                                           \r
                                           Old Spyglass was added to inventory.\u201d  """ //
                        //
                        );
                        player.addItem(new Item("SpyGlass"));
                    
                    } else if (Map.needsBoat(player.getX(),player.getY())){

                        System.out.println("you dive down into the depths but come up empty handed");

                    } else {
                        System.out.println("""
                                   A heavy lead helmet attached to a thin tube below on top of the\r
                                   head. The weight should help you sink to find treasure.""");
                    }
                    break;

                case "tankard":
                    if(player.getX()== 3 && player.getY()== 3){
                        System.out.println("You pour the water from the tankard onto the torch, and you hear a loud scraping. As much as you look around, you cannot see anything that has changed.");
                        tankardCheck = true;
                    }else if (tankardCheck) {
                            System.out.println("A silver dented and scratched mug it's no longer full." );
                        
                    }else{
                        System.out.println("""
                                   A silver dented and scratched mug it's\r
                                   still filled with water surprisingly.""" );
                    }
                    break;

                case "spyglass":
                    
                    System.out.println("""
                                   You put your eye up to the spyglass and look out over the sea.\r
                                   As if with a mind of its own, it seems to want to linger its \r
                                   sights upon the cave to the east.""" //
            //
            );
                    break;
            }
            System.out.println("You put away your " + choice);
        }


    }
}