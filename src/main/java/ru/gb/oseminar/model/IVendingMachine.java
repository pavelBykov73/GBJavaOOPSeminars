package ru.gb.oseminar.model;

public interface IVendingMachine {
    Product getProduct(String name) throws IllegalStateException;

    void addProduct(Product newItem);

}
