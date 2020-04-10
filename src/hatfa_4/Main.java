package hatfa_4;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        List<Item> itemsService = Arrays.asList(new ServiceItem("Temizlik", 50),
                                         new ServiceItem("Yemek", 100),
                                         new ServiceItem("Okul", 250));

        List<Item> itemsProduct = Arrays.asList(new ProductItem("Kalem", 23, 2),
                                                new ProductItem("Paket kagit", 50, 5),
                                                new ProductItem("Silgi", 35, 10));


        Order order = new Order();

        order.add(itemsService.get(0));
        order.add(itemsProduct.get(0));
        order.add(itemsService.get(1));
        order.printItems();
        System.out.format("%nTotal Price : " + String.valueOf(order.getTotalPrice()) + "%n%n");

        BundleItem bundleItemService = new BundleItem(itemsService.get(0),20);
        bundleItemService.add(itemsService.get(1));
        bundleItemService.printItems();
        System.out.format("%nTotal Bundle Price : " + String.valueOf(bundleItemService.getPrice()) + "%n%n");

        order.add(itemsProduct.get(1));
        order.add(itemsService.get(2));
        order.add(itemsProduct.get(2));
        order.printItems();
        System.out.format("%nGrandTotal Price : " + String.valueOf(order.getTotalPrice()) + "%n%n");

        BundleItem bundleItemProductItem = new BundleItem(itemsProduct.get(1),40);
        bundleItemProductItem.add(itemsProduct.get(2));
        bundleItemProductItem.printItems();
        System.out.format("%nTotal Bundle Price : " + String.valueOf(bundleItemProductItem.getPrice()) + "%n%n");

        bundleItemProductItem.add(bundleItemService);
    }
}
