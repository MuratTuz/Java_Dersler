package hatfa_4;

import hatfa_4.Item;

public class ServiceItem extends Item {
    public ServiceItem(String description, int price) {
        super(description, price);
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public int getPrice() {
        return price;
    }

}
