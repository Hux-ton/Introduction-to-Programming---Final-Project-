package data;

public class Map {


    public static int X = 5;
    public static int Y = 5;
    public static String names[][] = new String[X][Y];
    public static String descs[][]= new String[X][Y];
    public static boolean requiresBoat[][]= new boolean[X][Y];
    public static boolean requiresSpyGlass[][]= new boolean[X][Y];

    public Map(int x, int y) {

        names[0][0] = "TITLE";
        descs[0][0] = "DESCRIPTION";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0] = false;
    }
    public static void initalizeMaps(){
        names[0][0] = "TITLE";
        descs[0][0] = "DESCRIPTION";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0] = false;

        names[0][1] = "TITLE2";
        descs[0][1] = "DESCRIPTION2";
        requiresBoat[0][1] = false;
        requiresSpyGlass[0][1] = false;

        names[0][2] = "TITLE3";
        descs[0][2] = "DESCRIPTION3";
        requiresBoat[0][2] = false;
        requiresSpyGlass[0][2] = false;

        names[0][3] = "TITLE4";
        descs[0][3] = "DESCRIPTION4";
        requiresBoat[0][3] = true;
        requiresSpyGlass[0][3] = false;

        names[1][0] = "TITLE";
        descs[1][0] = "DESCRIPTION";
        requiresBoat[1][0] = true;
        requiresSpyGlass[1][0] = false;
        
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
