package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }
    /// to check ///////////--------------------------------
    public void add(Rabbit rabbit) {
        if (data.size() < capacity) {
            data.add(rabbit);
        }
    }

    public void removeRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                data.remove(rabbit);
                return;
            }
        }
    }

    public void removeSpecies(String species) {
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                data.remove(species);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit datum : data) {
            if (datum.getName().equals(name)) {
                datum.setAvailable(false);
                return datum;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitList= new ArrayList< >();
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbitList.add(rabbit);
            }
        }
        return rabbitList;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:", this.name));
        data.stream()
                .forEach(r -> sb.append(r + System.lineSeparator()));
        return sb.toString();
    }
}
