package service;

import model.Client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataProvider {
    String provider;

    public DataProvider(String provider) {
        this.provider = provider;
    }

    public List<Client> restore() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(provider))) {
            return ((List<Client>) ois.readObject());
        } catch (Exception ex) {
        }
        return null;
    }

    public boolean store(List<Client> clients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(provider))) {
            oos.writeObject(clients);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
