package enumTypes;

/**
 * Created by Олег on 12.02.2017.
 */
public enum OrderStatus {
    NEW("Новый"),               ACCEPTED("Пинят"),
    FORMED("Сформированный"),   PAID_UP("Оплаченный"),
    SENT("Отправленный"),       DELIVERED("Доставленый"),
    CANCELED("Отменен");

    private String label;

    OrderStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
