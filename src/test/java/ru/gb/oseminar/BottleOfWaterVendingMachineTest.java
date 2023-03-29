package ru.gb.oseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.oseminar.model.Drink;
import ru.gb.oseminar.model.DrinkVendingMachine;
import ru.gb.oseminar.model.Product;

import java.util.ArrayList;
import java.util.List;

class BottleOfWaterVendingMachineTest {

    private List<Product> products;
    private DrinkVendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();
        this.vendingMachine = new DrinkVendingMachine(products);
    }

    @Test
    void getProductTestSuccessful() {
        // expected
        products.add(new Drink("ExampleName1", 1.0d, 1000));
        products.add(new Drink("ExampleName2", 2.0d, 500));
        this.vendingMachine = new DrinkVendingMachine(products);
        Drink expected = new Drink("ExampleName2", 2.0d, 500);

        // actual
        Drink actual = vendingMachine.getProduct("ExampleName2", 500);

        Assertions.assertEquals(expected, actual);
    }
}