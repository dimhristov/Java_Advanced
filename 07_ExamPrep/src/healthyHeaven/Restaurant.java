package healthyHeaven;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        data = new ArrayList<>();
    }

    public void add(Salad salad) {
        data.add(salad);
    }

    public boolean buy(String name) {
        for (Salad salad : data) {
            if (salad.getName().equals(name)) {
                data.remove(salad);
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        List<Salad> test = data.stream().sorted( (p1,p2)-> p1.getTotalCalories() -p2.getTotalCalories()).collect(Collectors.toList());
        return test.get(0);
    }

    public String generateMenu() {
        StringBuilder sb =new StringBuilder();
        sb.append(String.format("%s have %d salads", this.name, data.size()));
        sb.append(System.lineSeparator());
        for (Salad datum : data) {
            sb.append(datum);
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }
}
