import java.util.Scanner;
import utils.*;

public class Main{

    public  static boolean gameRunning =  false;
    private static Player PlayerOne;
    private static Scanner myInput;

    private static void gameStart(){
        myInput = new Scanner(System.in);
        PlayerOne =  new Player();
        PlayerOne.setHP(10);
        System.out.println("Start game script");
        
        System.out.print("And what would be your name? ");
        String name = myInput.nextLine();
        PlayerOne.setPlayerName(name);
        
        System.out.println("Ahh yes your name is "+ PlayerOne.getPlayerName());

        System.out.println("Rummaging through the sand around you you feel your sheathed weapon But what was that weapon? ");
        System.out.print("a Rusty [F]lintlock or a flimsy [D]agger");

        gameRunning = true;
        
    }

    public static void main(String[] args){


        gameStart();
        PlayerOne.getHP();
        while (gameRunning) { 
                
            System.out.println("Games on");
            break;
            
        }
    }

}
