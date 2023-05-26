import java.time.LocalDate;

public final class Flat extends Property {

    private int flatNumber;
    private int floor;

    public Flat(String street, int houseNumber, String city, String postalCode, double livingArea, double price, LocalDate offerDate, int flatNumber, int floor) {
        super(street, houseNumber, city, postalCode, livingArea, price, offerDate);
        this.flatNumber = flatNumber;
        this.floor = floor;
    }

    public int getFloor() {
        return this.floor;
    }

    @Override
    public String toString() {
        return "\n" + "street: " + this.street + "\nhouseNumber: " + this.houseNumber + "\ncity: " + this.city + "\npostal code: " + this.postalCode + "\n" + "living area: " + this.livingArea + "\n" + "price: " + this.price + "\n" + "offer date: " + this.offerDate + "\n" + "flat number: " + this.flatNumber + "\n" + "floor: " + this.floor + "\n";
    }
}