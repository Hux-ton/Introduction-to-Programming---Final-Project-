package data;

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    public String toString() {
        return name;
    }

    
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}





