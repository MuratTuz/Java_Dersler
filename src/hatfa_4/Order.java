package hatfa_4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Order {

    List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public boolean remove(Item item){
        return items.remove(item);
    }

    public boolean add(Item item) throws CloneNotSupportedException {
       if (item instanceof BundleItem) return false;
       Item newItem = (Item) item.clone();
        return items.add(newItem);
    }

    Function<Item,Integer> foncInteger = item -> item.getPrice();


    BinaryOperator<Integer> binaryItem = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            return integer + integer2;
        }
    };

    Consumer<Item> foncConsumer = item -> item.print();

    public int getTotalPrice(){

        return items.stream().map(element ->foncInteger.apply(element)).reduce(0, binaryItem);
    }

    public void printItems(){

        //items.stream().forEach(foncConsumer);
        items.stream().forEach(Item::print);
    }

}
