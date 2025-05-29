package data;

import utils.*;

public class Map {

    private String title;
    private String script;
    public static int X;
    public static int Y;
    
    public Map(String title, String script){

        this.title = title;
        this.script = script;
        this.X = X;
        this.Y = Y;

    }

    public void Cove(){
        title = "Cove";
        script = "Help me";
        X = 0;
        Y = 0;
    }

    public static boolean needsBoat(int newX, int newY) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'needsBoat'");
    }
    

}
