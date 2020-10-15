package com.company;

import java.util.Comparator;

public class ComparatorByAmount implements Comparator<Item> {

    public int compare(Item i1, Item i2)
    {
        return i1.getCount() - i2.getCount();
    }
}
