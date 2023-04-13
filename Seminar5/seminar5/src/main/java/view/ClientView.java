package view;

import model.Client;
import model.Person;

import java.time.LocalDate;
import java.util.List;

import static view.Console.inputDate;

public class ClientView implements IUserView<Client> {
    public ClientView() {
    }

    public static int getDepositChangeValue() {
        return Console.inputInteger("Введите сумму операции:");
    }

    public static void textMsg(String s) {
        System.out.println(s);
    }

    @Override
    public void print(List<Client> list) {
        int i = 0;
        for (Client client : list) {
            System.out.println(i + ": " + client);
            i++;
        }
    }
}
