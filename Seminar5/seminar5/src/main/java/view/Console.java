package view;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Console {
    public static int inputIntegerLimit(String msg, int min, int max) {
        msg += "(" + min + " - " + max + ")";
        int inNumber;
        do {
            inNumber = inputInteger(msg);
        }
        while (inNumber < min || inNumber > max);
        return inNumber;
    }

    public static int inputInteger(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Необходимо ввести целое число:");
            }
        }
    }

    public static String inputString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static LocalDate inputDate(String msg) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date;
        while (true) {
            try {
                date = LocalDate.parse((CharSequence) /*"2018-12-27"*/inputString(msg));
                return date;
            } catch (DateTimeParseException exception) {
                System.out.println("Необходимо ввести дату корректно!");
            }
        }
    }
}
