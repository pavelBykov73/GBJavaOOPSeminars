package ru.gb.oseminar.model;

import java.util.Comparator;

public class DrinkVolumeComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1 instanceof Drink && o2 instanceof Drink) {
            return Integer.compare(((Drink) o1).getVolume(), ((Drink) o2).getVolume());
        }
        return 0;
    }
}
