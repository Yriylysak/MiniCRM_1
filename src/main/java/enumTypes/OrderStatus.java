package enumTypes;

/**
 * Created by Олег on 12.02.2017.
 */
public enum OrderStatus {
    ACCEPTED("Оформленный"), FORMED("Сформированный"), PAID_UP("Оплаченный"), CLOSED("Закрытый");
    private String label;

    OrderStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
