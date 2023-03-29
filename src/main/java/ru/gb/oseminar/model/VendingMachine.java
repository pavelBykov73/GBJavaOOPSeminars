package ru.gb.oseminar.model;

public interface VendingMachine {
    Product getProduct(String name) throws IllegalStateException;

    void addProduct(Product newItem);

}
