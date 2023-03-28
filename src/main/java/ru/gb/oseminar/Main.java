package ru.gb.oseminar;

import java.util.ArrayList;
import java.util.List;

/**
 * Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
 * Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и
 * реализовать перегруженный метод getProduct(int name, int volume, int temperature)
 * выдающий продукт соответствующий имени, объему и температуре
 * В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат
 * и воспроизвести логику заложенную в программе
 * Все вышеуказанное создать согласно принципам ООП пройдённым на семинаре
 */
public class Main {
    private static List<Product> products;
    private static BottleOfWaterVendingMachine machine;

    public static void main(String[] args) {
        products = new ArrayList<>();
        machine = new BottleOfWaterVendingMachine(products);
        machine.addProduct(new BottleOfWater("Сенеж", 40.0, 500));
        machine.addProduct(new BottleOfWater("Молоко", 100.0, 450));
        machine.addProduct(new BottleOfWater("Пепси 1.5l", 300.0, 1500));
        machine.addProduct(new BottleOfWater("Кола 1l", 200.0, 1000));

//ArrayList list = machine.getProductByName("water");
        try {
            System.out.println(machine.getProduct("молоко"));

            BottleOfWater bottleOfWater = machine.getProduct("Кол", 1000);
            System.out.println(bottleOfWater);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}