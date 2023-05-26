public class Main {
    public static void main(String[] args) {
        Cylinder test = new Cylinder(1.1, 1.1);
        System.out.println(test.getHeight());
        System.out.println(test.getRadius());
        test.setRadius(5.0);
        System.out.println(test.getRadius());
        test.setHeight(5.0);
        System.out.println(test.getHeight());
        System.out.println(test.baseArea());
        System.out.println(test.sideArea());
        System.out.println(test.totalArea());
        System.out.println(test.volume());
    }
}