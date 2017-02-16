package enumTypes;

/**
 * Created by Олег on 13.02.2017.
 */
public enum Gender {
    MALE("Мужчина"), FEMALE("Женщина");
    private String label;

    Gender(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

}
