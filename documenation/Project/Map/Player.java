import java.util.ArrayList;
import java.util.List;

public class Player {
    private int x = 0;
    private int y = 0;
    private List<Item> inventory = new ArrayList<>();

    public Player() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean hasItem(String name) {
        for (Item i : inventory) {
            if (i.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("You got the: " + item.getName());
    }

    public void removeItem(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(name)) {
                inventory.remove(i);
                System.out.println(name +"removed" );
                break;
            }
        }
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Nothing");
        } else {
            System.out.print("You have:");
            for (Item i : inventory) {
                System.out.print(i.getName() + " ");
            }
            System.out.println();
        }
    }
}






