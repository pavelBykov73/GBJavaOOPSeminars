package ru.gb.oseminar.data;

import java.util.List;

public class Numerator<T extends INumerate> {
    private List<PersonNumerable> numerateList;

    public Numerator(List<PersonNumerable> numerateList) {
        this.numerateList = numerateList;
    }

    public Long getUniqueId() {
        Long countMaxId = 0L;
        for (INumerate id : numerateList) {
            if (id.get() > countMaxId) {
                countMaxId = id.get();
            }
        }
        countMaxId++;
        return countMaxId;
    }
}
