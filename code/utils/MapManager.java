package utils;

import java.util.Scanner;
import data.*;
import utils.*;
public class MapManager {
    private Player player;
    private Scanner scanner;

    public MapManager(Player player) {
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Enter (n/w/e/s) for move,(Talk) with the old man, (Inv) for check inventory,(Quit) for close the game。");
        while (true) {
            System.out.print("Order: ");
            String cmd = scanner.nextLine().trim().toLowerCase();

            if (cmd.equals("quit")) {
                break;
            } else if (cmd.equals("talk")) {
                handleTalk();
            } else if (cmd.equals("inv")) {
                player.showInventory();
            } else if (cmd.length() == 1 && "wens".contains(cmd)) {
                handleMove(cmd);
            } else {
                System.out.println("Invalid order, please enter w/e/n/s, talk, inv, quit。");
            }
        }
        System.out.println("Game Exited");
    }

    private void handleTalk() {//Get the boat form old man.
        if (player.getX() == 0 && player.getY() == 0) {
            if (!player.hasItem("Boat")) {
                player.addItem(new Item("Boat"));
                System.out.println("Old man: Let's go further with this boat!");
            } else {
                System.out.println("Old man: I have nothing left for you.");
            }
        } else {
            System.out.println("No one in here");
        }
    }

    private void handleMove(String dir) {
        int newX = player.getX();
        int newY = player.getY();

        if (dir.equals("w")) newX--;
        else if (dir.equals("e")) newX++;
        else if (dir.equals("n")) newY++;
        else if (dir.equals("s")) newY--;

        //Preventing out-of-map range
        if (newX < 0 || newX >= Map.X || newY < 0 || newY >= Map.Y) {
            System.out.println("Cannot exceed the map ");
            return;
        }

        // Detect whether the player has a boat, otherwise cannot enter the ocean
        if (Map.needsBoat(newX, newY) && !player.hasItem("Boat")) {
            System.out.println("you need a boat from old man");
            return;
        }

        //The boat hit a reef, return to the birth point
        if (newX == 2 && newY == 0) {
            System.out.println("Your ship is sunk. . . .");
            newX = 0;
            newY = 0;
        }

        // (1,4)Communicate with pirate ships and merchant ships
        if (newX == 1 && newY == 4) {
            System.out.println("You encountered two ships:1) Pirate Ship  2) Merchant Ship");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                if (player.hasItem("Boat")) {
                    player.removeItem("Boat");//When select 1, the ship will be automatically cleared
                    System.out.println("Pirates took your ship and you were thrown into the sea and drowned.");
                    newX = 0; //back to start point
                    newY = 0;
                }
            } else if (choice.equals("2")) {
                if (!player.hasItem("Key")) {
                    player.addItem(new Item("Key"));
                    System.out.println("Merchant: The key can help you");
                } else {
                    System.out.println("Merchant: You already have the key");
                }
            } else {
                System.out.println("enter 1 or 2");
                return;
            }
        }

        if (newX == 3 && newY == 2 && !player.hasItem("Key")) {//Check if you have a key
            System.out.println("This is a stone gate, You need a key to enter");
            return;
        }

        //Calculating the player's position
        player.setX(newX);
        player.setY(newY);
        System.out.println("Now position: (" + newX + "," + newY + ") " + Map.getName(newX, newY));
        //System.out.println(Map.getDescs(newX, newY));
    }
}