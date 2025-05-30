package data;

public class Map {


    public static int X = 5;
    public static int Y = 5;
    public static String names[][] = new String[X][Y];
    public static String descs[][] = new String[X][Y];
    public static Boolean requiresBoat[][] = new Boolean[X][Y];
    public static Boolean requiresSpyGlass[][] = new Boolean[X][Y];

    public Map(int x, int y) {

    }

    public static void initalizeMaps() {

        names[0][0] = "======================= Shipwreck Shores =======================";
        descs[0][0] = """
                An empty beach with nothing of interest. To your East is the\r
                Ocean, and to your North the beach continues.\r
                \r
                ================================================================""";
        requiresBoat[0][0] = false;
        requiresSpyGlass[0][0] = false;

        names[0][1] = "========================= Lonely Beach =========================";
        descs[0][1] = """
                A lone sign sits on the beach; it points North and says, “Port\r
                Town”. To your East is the Ocean, to your South is the rest of\r
                the beach, and to your North is Port Town.
                \r
                ================================================================""";
        requiresBoat[0][1] = false;
        requiresSpyGlass[0][1] = false;

        names[0][2] = "========================== Port Town ==========================";
        descs[0][2] = """
                You appear to be in a town sitting on the docks of a beach. As\r
                you look around you can see many people, all keeping to\r
                themselves, except for a worried looking man searching the sand.\r
                \r
                ================================================================""";
        requiresBoat[0][2] = false;
        requiresSpyGlass[0][2] = false;

        names[0][3] = "========================== Open Ocean ==========================";
        descs[0][3] = """
                You are sailing on the high seas.\r
                You can see that Northeast there is a merchant ship. You can also\r
                see that in the distant East is an island with a cave, and in the\r
                distant South there are jagged rocks.\r
                To your South there is a port where you can dock your ship.\r
                \r
                ================================================================""";
        requiresBoat[0][3] = true;
        requiresSpyGlass[0][3] = false;

        names[0][4] = "========================== Open Ocean ==========================";
        descs[0][4] = """
                You are sailing on the high seas.\r
                You can see that East there is a merchant ship. You can also see\r
                that in the distant East is an island with a cave, and in the\r
                distant South there are jagged rocks.\r
                \r
                ================================================================""";
        requiresBoat[0][4] = true;
        requiresSpyGlass[0][4] = false;

        names[1][0] = "========================== Open Ocean ==========================";
        descs[1][0] = """
                You are sailing on the high seas.\r
                You can see that East there is a sunken ship. You can also see that\r
                in the distant East is an island with a cave, and in the distant North\r
                there is a ship.\r
                To your West there is a beach.\r
                \r
                ================================================================""";
        requiresBoat[1][0] = true;
        requiresSpyGlass[1][0] = false;

        names[1][1] = "========================== Open Ocean ==========================";
        descs[1][1] = """
                You are sailing on the high seas.\r
                You can see that Southeast there is a sunken ship. You can also see\r
                that in the distant East is an island with a cave, and in the distant\r
                North there is a ship.\r
                To your West there is a beach, but nowhere to dock your ship.\r
                \r
                ================================================================""";
        requiresBoat[1][1] = true;
        requiresSpyGlass[1][1] = false;

        names[1][2] = "========================== Open Ocean ==========================";
        descs[1][2] = """
                You are sailing on the high seas.\r
                You can see that in the distant North there is a ship, and in the\r
                distant East is an island with a cave, and in the distant South there\r
                are jagged rocks.\r
                To your West there is a port where you can dock your ship.\r
                \r
                ================================================================""";
        requiresBoat[1][2] = true;
        requiresSpyGlass[1][2] = false;

        names[1][3] = "========================== Open Ocean ==========================";
        descs[1][3] = """
                You are sailing on the high seas.\r
                You can see that North there is a merchant ship. You can also see that\r
                in the distant East is an island with a cave, and in the distant South\r
                there are jagged rocks.\r
                \r
                ================================================================""";
        requiresBoat[1][3] = true;
        requiresSpyGlass[1][3] = false;

        names[1][4] = "======================== Merchant Ship ========================";
        descs[1][4] = """
                You are sailing on the high seas.\r
                You approach a merchant ship.\r
                \r
                ================================================================""";
        requiresBoat[1][4] = true;
        requiresSpyGlass[1][4] = false;

        names[2][0] = "===================== Bay of a Sunken Ship =====================";
        descs[2][0] = """
                You are sailing on the high seas.\r
                You can see that East there are jagged rocks.\r
                Below there is a sunken ship.\r
                \r
                ================================================================""";
        requiresBoat[2][0] = true;
        requiresSpyGlass[2][0] = false;

        names[2][1] = "========================== Open Ocean ==========================";
        descs[2][1] = """
                You are sailing on the high seas.\r
                You can see that South there is a sunken ship. You can also see that\r
                in the East is an island with a cave, and in the distant North there is\r
                a merchant ship.\r
                \r
                ================================================================""";
        requiresBoat[2][1] = true;
        requiresSpyGlass[2][1] = false;

        names[2][2] = "========================== Open Ocean ==========================";
        descs[2][2] = """
                You are sailing on the high seas.\r
                To your East you can see a beach with a cave. You can also see that in\r
                the distant North there is a merchant ship, and in the distant South there\r
                are jagged rocks.\r
                You are able to dock your ship on the beach to your East.\r
                \r
                ================================================================""";
        requiresBoat[2][2] = true;
        requiresSpyGlass[2][2] = false;

        names[2][3] = "========================== Open Ocean ==========================";
        descs[2][3] = """
                You are sailing on the high seas.\r
                You can see that North there is a merchant ship. You can also see that in\r
                the East is an island with a cave, and in the distant South there are\r
                jagged rocks.\r
                \r
                ================================================================""";
        requiresBoat[2][3] = true;
        requiresSpyGlass[2][3] = false;

        names[2][4] = "========================== Open Ocean ==========================";
        descs[2][4] = """
                You are sailing on the high seas.\r
                You can see that West there is a merchant ship. You can also see that in\r
                the distant Southeast is an island with a cave, and in the distant South\r
                there are jagged rocks.\r
                \r
                ================================================================""";
        requiresBoat[2][4] = true;
        requiresSpyGlass[2][4] = false;

        names[3][1] = "========================== Open Ocean ==========================";
        descs[3][1] = """
                You are sailing on the high seas.\r
                You are surrounded by jagged rocks, but to the North there is a beach with\r
                a cave that you can dock your ship to.\r
                \r
                ================================================================""";
        requiresBoat[3][1] = true;
        requiresSpyGlass[3][1] = false;

        names[3][2] = "========================= Gravel Beach =========================";
        descs[3][2] = """
                You are on a beach, there is a cave close by, however it is partially closed\r
                with only a small gap to the inside. You can see the gap is way too small for\r
                you to get in, without opening it further.\r
                On closer inspection you can see a hole in the wall next to the door.\r
                \r
                ================================================================""";
        requiresBoat[3][2] = false;
        requiresSpyGlass[3][2] = false;

        names[3][3] = "======================= Lightly Lit Room =======================";
        descs[3][3] = """
                In the centre of the room is a single lit torch, illuminating the rest of the\r
                room. On the North wall you can see writing. It states: “To meet with the\r
                pirates of old, you must first relieve your shadow!”.\r
                \r
                ================================================================""";
        requiresBoat[3][3] = false;
        requiresSpyGlass[3][3] = true;

        names[4][2] = "====================== Dank and Wet Cave ======================";
        descs[4][2] = """
                You appear to be in a dank cave with a slight opening to your West, all the\r
                directions are blocked off, except for North where the cave continues. There\r
                is water dripping from the South wall and overflowing into a small tankard in\r
                the floor. You decide to take it as you might become thirsty.\r
                Tankard was added to your inventory.\r
                \r
                ================================================================""";
        requiresBoat[4][2] = false;
        requiresSpyGlass[4][2] = true;

        names[4][3] = "===================== Suspicious Cave Room =====================";
        descs[4][3] = """
                This room is empty, with scratches on the stone floor and a path leading West.\r
                There’s something unusual about the wall to the North.\r
                \r
                ================================================================""";
        requiresBoat[4][3] = false;
        requiresSpyGlass[4][3] = true;

        names[4][4] = "=================== Den of the Great Kraken ===================";
        descs[4][4] = """
                You enter the room and see the most gold you have ever seen. As you slowly\r
                walk towards it, in amazement, a great sea beast vaults from a pond at the\r
                back of the room. You scream “KRAKEN” as it grabs one of your legs.\r
                \r
                ================================================================""";
        requiresBoat[4][4] = false;
        requiresSpyGlass[4][4] = true;
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
