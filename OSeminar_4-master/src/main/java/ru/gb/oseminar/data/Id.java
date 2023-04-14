package ru.gb.oseminar.data;

public class Id implements INumerate {
    Long id;

    public Id(Long id) {
        this.id = id;
    }

    @Override
    public Long get() {
        return id;
    }

    @Override
    public void set(Long id) {
        this.id = id;
    }
}
