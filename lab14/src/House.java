import java.time.LocalDate;

public final class House extends Property {

    private double landArea;

    public House(String street, int houseNumber, String city, String postalCode, double livingArea, double price, LocalDate offerDate, double landArea) {
        super(street, houseNumber, city, postalCode, livingArea, price, offerDate);
        this.landArea = landArea;
    }

    @Override
    public String toString() {
        return "\n" + "street: " + this.street + "\n" + "houseNumber: " + this.houseNumber + "\ncity: " + this.city + "\npostal code: " + this.postalCode + "\n" + "living area: " + this.livingArea + "\n" + "price: " + this.price + "\n" + "offer date: " + this.offerDate + "\n" + "land area: " + this.landArea + "\n";
    }

}