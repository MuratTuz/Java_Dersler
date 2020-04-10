package hatfa_4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BundleItem extends Item {

    List<Item> items;
    private int discount;

    public BundleItem(Item item, int discount) {
        super(item.description, discount);
        this.discount = discount;
        items = new ArrayList<>();
        this.add(item);
    }

    public boolean remove(Item item){
        return items.remove(item);
    }

    public boolean add(Item item) {
        if (item instanceof BundleItem) {
            System.out.println("******* BundleItem cannot be recursive *******");
            return false;
        }
        this.applyDiscount(item);
        return items.add(item);
    }

    public int getDiscount() {
        return discount;
    }

    public void changeDiscount(int discount) {
        this.discount = discount;
    }

    public Item applyDiscount(Item item){
        item.setPrice((int) (item.price * (100 - discount) / 100));
        return item;
    }

    public void applyAllDiscount(){
        List<Item> newItems = items.stream().map(element->this.applyDiscount(element)).collect(Collectors.toList());
        this.items = newItems;
    }

    @Override
    int getPrice() {
        return items.stream().map(element ->element.getPrice()).reduce(0, (x,y)->x+y);
    }

    void printBundle(Item item) {
        System.out.println(item.description + " Bundle Price : " + String.valueOf(item.getPrice()));
    }

    public void printItems(){

        items.stream().forEach(x->this.printBundle(x));
    }
}
