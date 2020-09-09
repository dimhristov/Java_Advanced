package guild;

public class Player {

    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        setName(name);
        setClazz(clazz);
        this.rank = "Trial";
        this.description = "n/a";

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return this.clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Player %s: %s", name, clazz));
        sb.append(System.lineSeparator());
        sb.append(String.format("Rank: %s", rank));
        sb.append(System.lineSeparator());
        sb.append(String.format("Description: %s", description));
        return sb.toString();
    }
}
