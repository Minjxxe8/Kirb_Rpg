package World;

public enum ItemType {
    HEAL("Soin"),
    POWER("Pouvoir");

    private String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
