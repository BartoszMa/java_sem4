import java.time.LocalDate;

abstract sealed class Property permits House, Flat {
    protected String street;
    protected int houseNumber;
    protected String city;
    protected String postalCode;
    protected double livingArea;
    protected double price;
    protected LocalDate offerDate;

    public Property(String street, int houseNumber, String city, String postalCode, double livingArea, double price, LocalDate offerDate) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.livingArea = livingArea;
        this.price = price;
        this.offerDate = offerDate;
    }

    public LocalDate getDate() {
        return this.offerDate;
    }

    public String getCity() {
        return this.city;
    }

    public double getPrice() {
        return this.price;
    }

    public double getLivingArea() {
        return this.livingArea;
    }
}
