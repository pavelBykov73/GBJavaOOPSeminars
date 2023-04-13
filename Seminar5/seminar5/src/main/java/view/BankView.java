package view;

import model.Bank;
import model.Client;

import java.util.List;

public class BankView implements IBankView {
    private Bank bank;

    public BankView(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void print(List<Client> list) {
        int i = 0;
        for (Client client : list) {
            System.out.println(i + ": " + client);
            i++;
        }
    }

    public Client selectClient(List<Client> clients) {
        int idx = Console.inputIntegerLimit("Введите индекс клиента:", 0, clients.size() - 1);
        return clients.get(idx);
    }

    public void textMsg(String s) {
        System.out.println(s);
    }

    public int getOperation() { // TODO create enum
        StringBuilder menuString = new StringBuilder()
                .append("\n == ")
                .append(bank.toString())
                .append(" == \n")
                .append("1 - view all clients\n")
                .append("2 - Operation with client\n")
                .append("3 - add new client\n")
                .append("4 - delete client\n")
                .append("0 - exit\n");
        textMsg(menuString.toString());
        return Console.inputIntegerLimit(">", 0, 4);
    }
}
