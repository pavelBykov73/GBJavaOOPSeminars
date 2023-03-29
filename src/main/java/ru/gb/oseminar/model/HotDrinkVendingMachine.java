package ru.gb.oseminar.model;

import java.util.List;

public class HotDrinkVendingMachine implements VendingMachine {
    private final List<Product> products; // Почему не HotDrink?
    private HotDrinkVendingMode mode;

    public HotDrinkVendingMachine(List<Product> products) {
        this.products = products;
        mode = HotDrinkVendingMode.NONE;
    }

    public HotDrinkVendingMode getMode() {
        return mode;
    }

    public void setMode(HotDrinkVendingMode mode) {
        this.mode = mode;
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }

    public HotDrink getProduct(String name, int volume, int temperature) {
        for (Product product : products) {
            if (product instanceof HotDrink) {
                if (product.getName().equalsIgnoreCase(name)
                        && ((HotDrink) product).getVolume() == volume) {
                    if (((HotDrink) product).getTemperature() == temperature) {
                        return (HotDrink) product;
                    } else if (((HotDrink) product).getTemperature() < temperature
                            && mode == HotDrinkVendingMode.HEATER) {
                        ((HotDrink) product).setTemperature(temperature);
                        return (HotDrink) product;
                    } else if (((HotDrink) product).getTemperature() > temperature
                            && mode == HotDrinkVendingMode.COOLER) {
                        ((HotDrink) product).setTemperature(temperature);
                        return (HotDrink) product;
                    }
                }
            }
        }
        System.out.printf("Продукт c названием %s, объемом %d и температурой %d не найден.",
                name, volume, temperature);
        return null;
//        throw new IllegalStateException(String.format("Продукт c названием %s, объемом %d и температурой %d не найден.",
//                name, volume, temperature));
    }

    public HotDrink getProduct(String name, int volume) {
        for (Product product : products) {
            if (product instanceof HotDrink) {
                if (product.getName().equalsIgnoreCase(name)
                        && ((HotDrink) product).getVolume() == volume
                ) {
                    return (HotDrink) product;
                }
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s, объемом %d не найден.",
                name, volume));
    }

    public void addProduct(Product newItem) {
        products.add(newItem);
    }
}
