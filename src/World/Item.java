package World;

public class Item {
    private String name;
    private int price;
    private ItemType type;
    private int value;

    public Item(String name, int price, ItemType type, int value) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.value = value;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public ItemType getType() { return type; }
    public int getValue() { return value; }
}
