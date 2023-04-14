package service;

import model.Client;
import view.ClientView;

public class ClientService {
    Client client;
    ClientView clientView;

    public ClientService(Client client) {
        this.client = client;
        this.clientView = new ClientView(client);
    }

    public ClientView getClientView() {
        return clientView;
    }

    public Client getClient() {
        return client;
    }

    public void depositOperation() {
        int value = clientView.getDepositChangeValue();
        if (client.pushDeposit(value)) {
            clientView.textMsg("Операция успешна!");
        } else {
            clientView.textMsg("Средств недостаточно! Операция провалена!");
        }
    }

    public int getOperationWithClient() {
        return clientView.getOperationWithClient();
    }
}
