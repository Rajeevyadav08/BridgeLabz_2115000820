package Feb25;

class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}

public class CarToJson {
    public static void main(String[] args) {
        try {
            Car car = new Car("Tesla", "Model S", 2023);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(car);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
