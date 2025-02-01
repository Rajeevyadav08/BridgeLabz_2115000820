package Jan31;
public class Circle {
    private double radius;
    public Circle() {
        this(1.0);
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public void displayCircleInfo() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }
    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        defaultCircle.displayCircleInfo();

        Circle customCircle = new Circle(5.0);
        customCircle.displayCircleInfo();
    }
}
