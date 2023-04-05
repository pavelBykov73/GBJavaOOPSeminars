package ru.gb.oseminar;

import ru.gb.oseminar.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Проведена оптимизация структуры, используя обобщения, итераторы и компараторы
 * <p>
 * Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
 * Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и
 * реализовать перегруженный метод getProduct(int name, int volume, int temperature)
 * выдающий продукт соответствующий имени, объему и температуре
 * В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат
 * и воспроизвести логику заложенную в программе
 * Все вышеуказанное создать согласно принципам ООП пройдённым на семинаре
 */
public class Main {
    private static DrinkVendingMachine drinkVendingMachine;
    private static HotDrinkVendingMachine hotDrinkVendingMachine;

    public static void main(String[] args) {
        drinkVendingMachine = new DrinkVendingMachine();
        PutProductToBottleOfWaterVendingMachine();

        hotDrinkVendingMachine = new HotDrinkVendingMachine();
        PutProductToHotDrinkVendingMachine();

        System.out.println("\nНапитки без сортировки в автомате : " + drinkVendingMachine);
        for (Product product : drinkVendingMachine) {
            System.out.println(product);
        }

        System.out.println("\nСортировка по имени:");
        drinkVendingMachine.sort(new ProductNameComparator());
        for (Product product : drinkVendingMachine) {
            System.out.println(product);
        }

        System.out.println("\nСортировка по цене:");
        drinkVendingMachine.sort(new DrinkVolumeComparator());
        for (Product product : drinkVendingMachine) {
            System.out.println(product);
        }

        System.out.println("\nНапитки без сортировки в автомате : " + hotDrinkVendingMachine);
        for (Product product : hotDrinkVendingMachine) {
            System.out.println(product);
        }

        System.out.println("\nСортировка по объему:");
        hotDrinkVendingMachine.sort(new DrinkVolumeComparator());
        for (Product product : hotDrinkVendingMachine) {
            System.out.println(product);
        }
        System.out.println("");

        try {
            // test BottleOfWaterVendingMachine
            System.out.println(drinkVendingMachine.getProduct("молоко"));

            Drink bottleOfWater = drinkVendingMachine.getProduct("Кола 1l", 1000);
            System.out.println(bottleOfWater);

            // test hotDrinkVendingMachine
            System.out.println(hotDrinkVendingMachine.getProduct("Чай горячий", 200, 90));
            System.out.println(hotDrinkVendingMachine.getProduct("Чай", 200, 90));
            System.out.println(hotDrinkVendingMachine.getProduct("Чай горячий", 200, 80));
            System.out.println(hotDrinkVendingMachine.getProduct("Американо", 250, 95));

            // проверим, сможем ли получить простые напитки
            System.out.println(hotDrinkVendingMachine.getProduct("Чай", 200));
            System.out.println(hotDrinkVendingMachine.getProduct("Молоко", 200));

            // и напиток без учета температуры
            System.out.println(hotDrinkVendingMachine.getProduct("Чай горячий", 200));

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
        drinkVendingMachine.addProduct(new Drink("Сенеж", 40.0, 500));
        drinkVendingMachine.addProduct(new Drink("Молоко", 100.0, 450));
        drinkVendingMachine.addProduct(new Drink("Пепси 1.5l", 300.0, 1500));
        drinkVendingMachine.addProduct(new Drink("Кола 1l", 200.0, 1000));
    }

    private static void PutProductToHotDrinkVendingMachine() {
        hotDrinkVendingMachine.addProduct(new HotDrink("Чай горячий", 40.0, 200, 90));
        hotDrinkVendingMachine.addProduct(new HotDrink("Капуччино", 250.0, 150, 88));
        hotDrinkVendingMachine.addProduct(new HotDrink("Американо", 200.0, 250, 95));
        hotDrinkVendingMachine.addProduct(new HotDrink("Горячий шоколад", 150.0, 200, 70));
        // Для примера добавим несколько простых напитков
        hotDrinkVendingMachine.addProduct(new Drink("Чай", 40.0, 200));
        hotDrinkVendingMachine.addProduct(new Drink("Молоко", 20.0, 100));
    }
}