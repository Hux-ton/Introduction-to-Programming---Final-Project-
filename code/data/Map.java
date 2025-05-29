package data;

import utils.*;

public class Map {


    public static int X;
    public static int Y;
    public static String names[][];
    public static String descs[][];
    public static Boolean requiresBoat[][];
    public static Boolean requiresSpyGlass[][];

    public Map(int x, int y) {

        String names[][] = null;
        String descs[][] = null;
        Boolean requiresBoat[][] = null;
        Boolean requiresSpyGlass[][] = null;

        names[0][0] = "TITLE";
        descs[0][0] = "DESCRIPTION";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0] = false;

        names[0][0] = "TITLE";
        descs[0][0] = "DESCRIPTION";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0] = false;

        names[0][0] = "TITLE";
        descs[0][0] = "DESCRIPTION";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0] = false;

        names[0][0] = "TITLE";
        descs[0][0] = "DESCRIPTION";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0] = false;

        names[0][0] = "TITLE";
        descs[0][0] = "DESCRIPTION";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0] = false;
    }

    public static String getName(int x, int y) {
        return names[x][y];
    }

    public static String getDescs(int x, int y) {
        return descs[x][y];
    }

    public static boolean needsBoat(int x, int y) {
        return requiresBoat[x][y];
    }

    public static boolean needsSpyGlass(int x, int y) {
        return requiresSpyGlass[x][y];
    }
}
