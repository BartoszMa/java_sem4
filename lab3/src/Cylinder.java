
public class Cylinder {
    private double radius;
    private double height;

    public Cylinder(double setRadius, double setHeight) {
        this.radius = setRadius;
        this.height = setHeight;
    }

    public Cylinder() {

    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public void setHeight(double newHeight) {
        this.height = newHeight;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public double baseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double sideArea() {
        return 2 * Math.PI * radius * height;
    }

    public double totalArea() {
        return 2 * baseArea() + sideArea();
    }

    public double volume() {
        return baseArea() * height;
    }

}