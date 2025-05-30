public class Player {

    private String playerName;
    private int HP;

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
    public Weapons currentWeapons;

}
