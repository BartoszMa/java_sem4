import java.util.ArrayList;
import java.util.function.Predicate;

public class ListOffer {

    private ArrayList<Property> listOffer;

    public ListOffer() {
        this.listOffer = new ArrayList<Property>();
    }

    public void addOffer(House house) {
        listOffer.add(house);
    }

    public void addOffer(Flat flat) {
        listOffer.add(flat);
    }

    public <T> ArrayList<T> printOfferWith(Predicate<T> condition) {
        ArrayList<T> offerResult = new ArrayList<>();
        for (int i = 0; i < this.listOffer.size(); i++) {
            if (condition.test((T) this.listOffer.get(i))) {
                offerResult.add((T) this.listOffer.get(i));
            }
        }
        return offerResult;
    }


}