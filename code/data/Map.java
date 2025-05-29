package data;

import utils.*;

public class Map {

    public static int X;
    public static int Y;
    public static String names[][];
    public static String descs[][];
    
    public Map(int X,int Y){

        String names[][] = null;
        String descs[][] = null;
        Boolean requiresBoat[][] = null;
        Boolean requiresSpyGlass[][] = null;

        names[0][0] = "Home";
        descs[0][0] = "nothing here";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0]=false;

        names[1][0] ="Not home";
        descs[1][0] = "nothing here";

    }

    public static String getName(int newX, int newY) {
        return names[newX][newY];
    }

    public static boolean needsBoat(int newX, int newY) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'needsBoat'");
    }

}
