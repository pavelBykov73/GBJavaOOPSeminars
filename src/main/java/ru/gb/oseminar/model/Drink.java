package ru.gb.oseminar.model;

public class Drink extends Product {
    private int volume;


    public Drink(String name, double cost, int volume) {
        super(name, cost);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Drink {" +
                "name='" + super.getName() + '\'' +
                ", volume='" + this.volume + '\'' +
                ", cost=" + super.getCost() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Drink)) {
            return false;
        }

        Drink that = (Drink) o;

        return super.getName().equalsIgnoreCase(that.getName())
                && super.getCost() == that.getCost()
                && getVolume() == that.getVolume();
    }
}
