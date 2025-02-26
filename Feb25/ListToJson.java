package Feb25;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Car {
    private String brand, model; 
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand; this.model = model; this.year = year;
    }
}

public class ListToJson {
    public static void main(String[] args) throws Exception {
        List<Car> cars = Arrays.asList(new Car("Tesla", "Model S", 2023), new Car("BMW", "X5", 2022), new Car("Audi", "A6", 2021));
        System.out.println(new ObjectMapper().writeValueAsString(cars));
    }
}

