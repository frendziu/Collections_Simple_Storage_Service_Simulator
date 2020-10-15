package com.company;

import java.util.Comparator;

public class MaxComparator implements Comparator<Item> {

    int max = 0;
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o1.getCount(), o2.getCount());
    }
}
