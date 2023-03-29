package ru.gb.oseminar.model;

public class HotDrink extends Drink {
    private int temperature;

    public HotDrink(String name, double cost, int volume, int temperature) {
        super(name, cost, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    /**
     * Нагрев / охлаждение напитка
     *
     * @param temperature
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "HotDrink {" +
                "name='" + super.getName() + '\'' +
                ", volume='" + super.getVolume() + '\'' +
                ", temperature='" + this.temperature + '\'' +
                ", cost=" + super.getCost() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HotDrink)) {
            return false;
        }

        HotDrink that = (HotDrink) o;

        return super.getName().equalsIgnoreCase(that.getName())
                && super.getCost() == that.getCost()
                && super.getVolume() == that.getVolume()
                && getTemperature() == that.getTemperature();
    }

}
