package hatfa_4;

public abstract class Item implements Cloneable {
    protected String description = null;

    public void setPrice(int price) {
        this.price = price;
    }

    protected int price;

    public Item(String description, int price) {
        this.description = description;
        setPrice(price);
    }

    abstract int getPrice();

     void print(){
         System.out.println(description + " Price : " + String.valueOf(getPrice()));
     }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
