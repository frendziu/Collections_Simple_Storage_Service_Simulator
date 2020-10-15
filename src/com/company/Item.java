package com.company;

public class Item implements Comparable<Item> {

    String name;
    ItemCondition condition;
    double mass;
    int count;

    Item(String n, ItemCondition it, double m, int c)
    {
        name = n;
        condition = it;
        mass = m;
        count = c;
    }

    void print()
    {
        System.out.println("Dane towaru");
        System.out.println("Nazwa: "+name);
        System.out.println("Stan: "+condition);
        System.out.println("Masa: "+mass);
        System.out.println("Ilość: "+count);
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

}
