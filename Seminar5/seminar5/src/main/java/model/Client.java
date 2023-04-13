package model;

import java.time.LocalDate;
import java.util.Objects;

public class Client extends Person implements Comparable<Client> {
    private Long id;
    private int deposit;

    public Client(String firstName, String secondName, LocalDate dateOfBirth, Long id) {
        super(firstName, secondName, dateOfBirth);
        this.id = id;
        this.deposit = 0;
    }

    public Client(String firstName, String secondName, LocalDate dateOfBirth, Long id, int deposit) {
        super(firstName, secondName, dateOfBirth);
        this.id = id;
        this.deposit = deposit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDeposit() {
        return deposit;
    }

    public boolean pushDeposit(int debit) {
        if (this.deposit + debit < 0) {
            return false;
        }
        this.deposit += debit;
        return true;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", deposit=" + deposit +
                " " + super.toString() +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        return this.id.compareTo(o.getId()); // не может быть двух разных клиентов с однаковым id
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (id.equals(((Client) o).id)) return true;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
