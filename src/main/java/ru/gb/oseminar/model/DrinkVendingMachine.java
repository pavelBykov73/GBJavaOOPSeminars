package ru.gb.oseminar.model;

import java.util.Iterator;
import java.util.List;

public class DrinkVendingMachine extends VendingMachine {

    public DrinkVendingMachine() {
        super();
    }

    public Drink getProduct(String name, int volume) {
        for (Product product : products) {
            if (product instanceof Drink) {
                if (product.getName().equalsIgnoreCase(name) && ((Drink) product).getVolume() == volume) {
                    return (Drink) product;
                }
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }

    @Override
    public String toString() {
        return "Drink Vending Machine";
    }
}
