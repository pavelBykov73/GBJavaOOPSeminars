package view;

import model.Client;

public class ClientView implements IUserView<Client> {
    private Client client;

    public ClientView(Client client) {
        this.client = client;
    }

    public int getDepositChangeValue() {
        return Console.inputInteger("Введите сумму операции:");
    }

    public void textMsg(String s) {
        System.out.println(s);
    }

    public int getOperationWithClient() { // TODO create enum
        StringBuilder menuString = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - deposit operation\n")
                .append("2 - change First name\n")
                .append("0 - exit\n");
        textMsg(menuString.toString());
        return Console.inputIntegerLimit(">", 0, 2);
    }

    public void clientInfoUpdate(Client client) {
        textMsg(client.toString());
    }
}
