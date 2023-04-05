package ru.gb.oseminar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class VendingMachine implements IVendingMachine, Iterable<Product> {
    List<Product> products;
    int index;

    public VendingMachine() {
        this.products = new ArrayList<>();
        this.index = 0;
    }

    @Override
    public Product getProduct(String name) throws IllegalStateException {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        System.out.printf("Продукт c названием %s не найден.",
                name);
        return null;
//        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }

    @Override
    public void addProduct(Product newItem) {
        products.add(newItem);
    }

    @Override
    public String toString() {
        return "Vending Machine";
    }

    @Override
    public Iterator<Product> iterator() {
        Iterator<Product> it = new Iterator<Product>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < products.size();
            }

            @Override
            public Product next() {
                return products.get(index++);
            }
        };
        return it;
    }

    public void sort(Comparator<Product> comparator) {
        products.sort(comparator);
    }

}
