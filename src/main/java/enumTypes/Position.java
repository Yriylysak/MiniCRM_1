package enumTypes;

/**
 * Created by JL on 16.02.2017.
 */
public enum Position {
    ROOT("Root"),
    ADMIN("Admin"),
    MANAGER("Manager"),
    CASHIER("Cashier"),
    STOREKEEPER("Storekeeper");

    private String label;

    Position(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}

