package hatfa_4;

import hatfa_4.Item;

public class ProductItem extends Item {
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    private int amount;
    private int totalPrice;

    public ProductItem(String description, int pricePerUnit) {
        super(description, pricePerUnit);
        amount=1;

    }

    public ProductItem(String description, int amount, int pricePerUnit) {
        super(description, pricePerUnit);
        this.amount = amount;
    }

    @Override
    public int getPrice() {
        return this.price * amount;
    }

}
