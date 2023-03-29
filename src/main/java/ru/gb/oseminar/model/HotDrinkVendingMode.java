package ru.gb.oseminar.model;

public enum HotDrinkVendingMode {
    HEATER(1), COOLER(2), NONE(0);
    private int code;

    HotDrinkVendingMode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
