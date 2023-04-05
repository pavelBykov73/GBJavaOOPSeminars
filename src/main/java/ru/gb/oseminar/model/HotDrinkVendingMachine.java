package ru.gb.oseminar.model;

import java.util.List;

public class HotDrinkVendingMachine extends VendingMachine {
    private HotDrinkVendingMode mode;

    public HotDrinkVendingMachine() {
        mode = HotDrinkVendingMode.NONE;
    }

    public HotDrinkVendingMode getMode() {
        return mode;
    }

    public void setMode(HotDrinkVendingMode mode) {
        this.mode = mode;
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

    /**
     * Получение напитка без учета температуры
     *
     * @param name
     * @param volume
     * @return
     */
    public Drink getProduct(String name, int volume) {
        for (Product product : products) {
            if (product instanceof Drink || product instanceof HotDrink) {
                if (product.getName().equalsIgnoreCase(name)
                        && ((Drink) product).getVolume() == volume
                ) {
                    return (Drink) product;
                }
            }
        }
        System.out.printf("Продукт c названием %s, объемом %d не найден.",
                name, volume);
        return null;
    }

    @Override
    public String toString() {
        return "Hot Drink Vending Machine";
    }
}
