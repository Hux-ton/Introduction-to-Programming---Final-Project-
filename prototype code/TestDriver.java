import java.util.Random;
import java.util.Scanner;
public class TestDriver {

    //Method to create a chnace for us to miss an attack, accuracy can be changed depending on weapon stats
    public static void damage(Player AttackingPlayer, Player DefendingPlayer){
            Boolean didMiss = Miss(AttackingPlayer.currentWeapons.accuracy);
            if (didMiss == true){

                System.out.println("You missed");

            }
            else{
    
                Random rand =  new Random();
                int damage = rand.nextInt(AttackingPlayer.currentWeapons.damageMin,AttackingPlayer.currentWeapons.damageMax);
                DefendingPlayer.damageHP(damage);
            
                int currentHP = DefendingPlayer.getHP();
                String name = DefendingPlayer.getPlayerName();
                System.out.printf("You %s your %s and dealt %d damage to the %s%n",AttackingPlayer.currentWeapons.verb,AttackingPlayer.currentWeapons.name, damage,name);
            
                System.out.println(currentHP + " HP");
    
            }
    }
    public static void heal(Player NewPlayer){
            //put here check if the health potion counter in the inventory is empty
            Random rand =  new Random();
            int heal = rand.nextInt(30,40);
            NewPlayer.restoreHP(heal);
            int currentHP = NewPlayer.getHP();
    
            System.out.println("You healed yourself for "+heal+" HP. your new HP is:"+currentHP);
            
    }
        static boolean Miss(int accuracy){
    
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
    
    public static void playerChoice(int x,int y,Player player){

        Scanner Input = new Scanner(System.in);
        System.out.print("What would you like to do?" );
        String playerchoice = Input.next();
        if ("N".equalsIgnoreCase(playerchoice)){
            y=y+1;

        }
        else if("S".equalsIgnoreCase(playerchoice)){
            y=y-1;

        }
        else if("E".equalsIgnoreCase(playerchoice)){
            x=x+1;

        }
        else if("W".equalsIgnoreCase(playerchoice)){
            y=y-1;

        }
        else if("I".equalsIgnoreCase(playerchoice)){
            System.out.println("What item from your inventory would you like to use?");
            String printInv = player.returnInventory();
            System.out.println(printInv);
            String invChoice = Input.next();

        }
    }

    public void gameStart(Player PlayerOne){
        Scanner Input = new Scanner(System.in);
    
        System.out.printf("Welcome to [game title]%nDazed and with a dry sandy mouth you awaken on a cold empty beach with only your wits about you.%n The shore travels on North where you think you can see a bustling port town%nYou begin to recollect your faded memories.% Your name was: ");
        PlayerOne.setPlayerName(Input.next());
        System.out.printf("Of course! You are %sfeared swashbuckler of the Captain [last anmes]'s raiders.%n But it seem theyve marroned you all alone on this beach",PlayerOne.getPlayerName());
        
    }

        public static void main(String[] args) {
            
            //Creating our player character object and giving it a weapon and HP
            Player PlayerOne = new Player();
            PlayerOne.currentWeapons =  new Weapons_Dagger();
            PlayerOne.setHP(100);
            //change this a
            PlayerOne.setPlayerName("Huxton"); 
        
            //Creating an enemy object using the player class
            Player Pirate = new Player();
            Pirate.currentWeapons = new Weapons_Axe();
            Pirate.setHP(50);
            Pirate.setPlayerName("Blackbeard");
        
            //Creating our scanner object
            Scanner myInput = new Scanner(System.in);
                
            
            int x = 1;
            int y = 1;

            int position[][];
            

            playerChoice(x, y, PlayerOne);

            //Combat Class. Will call in enemy hp from enemies class 
            while(Pirate.getHP()>0){
                String input = null;
                while (!"A".equalsIgnoreCase(input) && !"H".equalsIgnoreCase(input) ){
                    System.out.printf("What will you do? %n [A]ttack | [H]eal : ");
                    input = myInput.next();
        
                }
                switch(input.toUpperCase()){
                    case "A":
                        System.out.println("Attacking");
                        //Call damage method
                        damage(PlayerOne,Pirate);
                        break;

                    case "H":
                        System.out.println("Healing");
                        //Call Healing method
                        heal(PlayerOne);
                        break;
                }
                damage(Pirate,PlayerOne);
            }
            

        }
    
}
