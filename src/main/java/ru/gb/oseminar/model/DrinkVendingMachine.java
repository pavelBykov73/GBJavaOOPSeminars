package ru.gb.oseminar.model;

import java.util.List;

public class DrinkVendingMachine implements VendingMachine {
    private final List<Product> products;

    public DrinkVendingMachine(List<Product> products) {
        this.products = products;
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
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

    public void addProduct(Product newItem) {
        products.add(newItem);
    }

}
