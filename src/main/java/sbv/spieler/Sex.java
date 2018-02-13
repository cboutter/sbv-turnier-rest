package sbv.spieler;

public enum Sex {
    M("Male"), F("Female");

    private final String description;

    Sex(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "description='" + description + '\'' +
                '}';
    }
}
