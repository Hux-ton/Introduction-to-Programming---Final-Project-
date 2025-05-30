import java.util.Random;

public class Combat {

    public void damage(Player DefPlayer,Player AttPlayer){
        
        if (Miss(AttPlayer.currentWeapons.accuracy) == true){
            System.out.printf("You missed");
        }
        else{

        Random rand =  new Random();
        int damage = rand.nextInt(AttPlayer.currentWeapons.damageMin,AttPlayer.currentWeapons.damageMax);
        DefPlayer.damageHP(damage);
        int currentHP = DefPlayer.getHP();

        String DefPlayerName = DefPlayer.getPlayerName();
        System.out.printf("You %s your %s and dealt %d damage to the %s",AttPlayer.currentWeapons.verb,AttPlayer.currentWeapons.name, damage,DefPlayerName);
        
        System.out.println(currentHP);

        }
    }

    public void heal(Player NewPlayer){
        //put here check if the health potion counter in the inventory is empty
        Random rand =  new Random();
        int heal = rand.nextInt(30,40);
        NewPlayer.restoreHP(heal);
        int currentHP = NewPlayer.getHP();

        System.out.println("You healed yourself for "+heal+" HP. your new HP is:"+currentHP);
        
    }

    public int NewHP(Player NewPlayer){
        return NewPlayer.getHP();
    }

    static boolean Miss(int accuracy){

        boolean didMiss = false;

        //Miss chance random object.
        Random rand =  new Random();
        int missChance = rand.nextInt(1,accuracy);

        if (missChance == 1){

            didMiss = true;

        }

        return didMiss;
    }

}
