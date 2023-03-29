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
    private static List<Product> bottleOfWatersProducts;
    private static List<Product> hotDrinkProducts;
    private static BottleOfWaterVendingMachine bottleOfWaterVendingMachine;
    private static HotDrinkVendingMachine hotDrinkVendingMachine;

    public static void main(String[] args) {
        bottleOfWatersProducts = new ArrayList<>();
        bottleOfWaterVendingMachine = new BottleOfWaterVendingMachine(bottleOfWatersProducts);
        PutProductToBottleOfWaterVendingMachine();

        hotDrinkProducts = new ArrayList<>();
        hotDrinkVendingMachine = new HotDrinkVendingMachine(hotDrinkProducts);
        PutProductToHotDrinkVendingMachine();

        try {
            // test BottleOfWaterVendingMachine
            System.out.println(bottleOfWaterVendingMachine.getProduct("молоко"));

            BottleOfWater bottleOfWater = bottleOfWaterVendingMachine.getProduct("Кола 1l", 1000);
            System.out.println(bottleOfWater);

            // test hotDrinkVendingMachine
            System.out.println(hotDrinkVendingMachine.getProduct("Чай горячий", 200, 90));
            System.out.println(hotDrinkVendingMachine.getProduct("Чай", 200, 90));
            System.out.println(hotDrinkVendingMachine.getProduct("Чай горячий", 200, 80));
            System.out.println(hotDrinkVendingMachine.getProduct("Американо", 250, 95));

            // По умолчанию, автомат выдает напиток, если температура точно совпадает с необходимой
            // Если включить режим "Нагрев", то автомат умеет и нагревать напиток до нужной температуры
            // Для эксперимента, поуправляем режимом извне (из Main) и проверим
            hotDrinkVendingMachine.setMode(HotDrinkVendingMode.HEATER);
            System.out.println(hotDrinkVendingMachine.getProduct("Капуччино", 150, 95));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void PutProductToBottleOfWaterVendingMachine() {
        bottleOfWaterVendingMachine.addProduct(new BottleOfWater("Сенеж", 40.0, 500));
        bottleOfWaterVendingMachine.addProduct(new BottleOfWater("Молоко", 100.0, 450));
        bottleOfWaterVendingMachine.addProduct(new BottleOfWater("Пепси 1.5l", 300.0, 1500));
        bottleOfWaterVendingMachine.addProduct(new BottleOfWater("Кола 1l", 200.0, 1000));
    }

    private static void PutProductToHotDrinkVendingMachine() {
        hotDrinkVendingMachine.addProduct(new HotDrink("Чай горячий", 40.0, 200, 90));
        hotDrinkVendingMachine.addProduct(new HotDrink("Капуччино", 250.0, 150, 88));
        hotDrinkVendingMachine.addProduct(new HotDrink("Американо", 200.0, 250, 95));
        hotDrinkVendingMachine.addProduct(new HotDrink("Горячий шоколад", 150.0, 200, 70));
    }
}