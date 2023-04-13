package service;

import model.Client;
import view.ClientView;

public class ClientService {
    Client client;

    public ClientService(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void depositOperation() {
        int value = ClientView.getDepositChangeValue();
        if (client.pushDeposit(value)) {
            ClientView.textMsg("Операция успешна!");
        } else {
            ClientView.textMsg("Средств недостаточно! Операция провалена!");
        }
    }

    public int getOperationWithClient() {
        return ClientView.getOperationWithClient();
    }
}
