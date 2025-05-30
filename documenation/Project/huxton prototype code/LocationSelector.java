public class Map {
    public static final int X = 5;
    public static final int Y = 5;
    static String[][] names = new String[X][Y];
    static String[][] descs = new String[X][Y];
    static boolean[][] requiresBoat = new boolean[X][Y];

    static {
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                names[x][y] = "";
                descs[x][y] = "nothing here";
                requiresBoat[x][y] = false;
            }
        }

        names[0][0] = "Start Point";
        descs[0][0] = "There's an old man over there, Maybe he can help you.";

        names[0][2] = "Port Town";
        descs[0][2] = "You need a boat to keep going.";

        names[1][4] = "Pirate Ship and Pirate Ship";
        descs[1][4] = "You can exchange some things with them.";

        names[2][0] = "Reef";
        descs[2][0] = "The ship hit a reef. You drowned.";

        names[3][0] = "Smile Island";
        descs[3][0] = "There is buried treasure here.";

        names[4][0] = "Smile Island";
        descs[4][0] = "There is a sword but you can't pull it out.";

        names[4][1] = "Smile Island";
        descs[4][1] = "Nothing here.";

        names[3][4] = "Lever";
        descs[3][4] = "You seem turn on something";

        names[4][2] = "Cave";
        descs[4][2] = "Too dark, you can't see anything. You feel the breath of danger.";

        names[4][4] = "Underground mine";
        descs[4][4] = "Your final enemy has appeared.";

        //The are where need boat
        requiresBoat[1][0] = true;
        requiresBoat[1][1] = true;
        requiresBoat[1][2] = true;
        requiresBoat[0][3] = true;
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
}
