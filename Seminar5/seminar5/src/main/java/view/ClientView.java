package view;

import model.Client;
import model.Person;

import java.time.LocalDate;
import java.util.List;

import static view.Console.inputDate;

public class ClientView implements IUserView<Client> {
    public ClientView() {
    }

    // TODO уйти от static
    public static int getDepositChangeValue() {
        return Console.inputInteger("Введите сумму операции:");
    }

    public static void textMsg(String s) {
        System.out.println(s);
    }

    public static int getOperationWithClient() { // TODO create enum
        StringBuilder menuString = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - deposit operation\n")
                .append("2 - change First name\n")
                .append("0 - exit\n");
        textMsg(menuString.toString());
        return Console.inputIntegerLimit(">", 0, 2);
    }

    public static void clientInfoUpdate(Client client) {
        textMsg(client.toString());
    }
}
