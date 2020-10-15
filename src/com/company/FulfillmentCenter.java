package com.company;

import java.util.*;

public class FulfillmentCenter {
    String warehauseName;
    List<Item> goodsList = new ArrayList<>();
    double capacity;
    double totalMass;

    FulfillmentCenter(String wn1, List<Item> list, double c)
    {
        warehauseName = wn1;

        capacity = c;

        for(Item i : list)
        {
            totalMass = i.mass*i.count;
        }
        if(totalMass>capacity)
        {
            System.err.println("Magazyn przepełniony");
            totalMass = 0;
            goodsList = new ArrayList<>();
        }
        else
        {
            goodsList = list;
        }

    }

    void addProduct(Item I)
    {
        if(goodsList.isEmpty())
        {
            goodsList.add(I);
            totalMass +=I.mass * I.count;
            if(totalMass>capacity)
            {
                System.err.println("Magazyn przepełniony");
            }
        }
        else{

            totalMass +=I.mass * I.count;
            if(totalMass>capacity)
            {
                System.err.println("Magazyn przepełniony");
            }
            else {
                goodsList.add(I);
                for(int i = 0; i<goodsList.size()-1; i++)
                {
                    if(goodsList.get(i).name.compareTo(I.name)==0 && goodsList.get(i).condition.compareTo(I.condition)==0)
                    {
                        goodsList.get(i).count+=I.count;
                        goodsList.remove(I);
                    }

                }
            }
        }

    }

    void getProduct(Item item)
    {
        boolean isExist = false;
        for(int i = 0; i<goodsList.size(); i++)
        {
            if(goodsList.get(i).name.compareTo(item.name)==0)
            {
                isExist = true;
                goodsList.get(i).count -= 1;
                if(goodsList.get(i).count == 0)
                {
                    goodsList.remove(item);
                }
            }

        }
        if(!isExist)
        {
            System.err.println("Produkt nie jest w magazynie");
        }
    }

    void removeProduct(Item item)
    {
        boolean isExist = false;
        for(int i = 0; i<goodsList.size(); i++)
        {
            if(goodsList.get(i).name.compareTo(item.name)==0)
            {
                  isExist = true;
                  goodsList.remove(item);

            }


        }
        if(!isExist)
        {
            System.err.println("Produkt nie jest w magazynie");
        }
    }

    void search(String productName)
    {
        boolean isExist = false;
        for(int i = 0; i<goodsList.size(); i++)
        {
            if(goodsList.get(i).name.compareTo(productName)==0)
            {
                isExist = true;
                goodsList.get(i).print();

            }


        }
        if(!isExist)
        {
            System.err.println("Produkt nie jest w magazynie");
        }
    }

    void searchPartial(String name) {
        boolean isExist = false;
        for (int i = 0; i < goodsList.size(); i++) {
            int searchMeLength = goodsList.get(i).name.length();
            int findMeLength = name.length();
            for (int j = 0; j <= (searchMeLength - findMeLength); j++) {
                if (goodsList.get(i).name.regionMatches(j, name, 0, findMeLength)) {
                    isExist = true;
                    goodsList.get(i).print();
                    break;
                }
            }
        }
        if (!isExist) {
            System.err.println("Produkt nie jest w magazynie");
        }
    }

    void countByCondition(ItemCondition itemCondition)
    {
        int itemCount = 0;
        boolean isExist = false;
        for(int i = 0; i<goodsList.size(); i++)
        {
            if(goodsList.get(i).condition == itemCondition)
            {
                isExist = true;
                itemCount += goodsList.get(i).count;
            }
        }

        if(!isExist)
        {
            System.err.println("Nie ma produktu o takim stanie");
        }
        else {
            System.out.println("Ilość produktów o stanie "+itemCondition+" to: "+itemCount);
        }
    }

    void summary()
    {
        System.out.println("Nazwa magazynu: "+warehauseName);
        System.out.println("Produkty: ");
        for(int i = 0; i<goodsList.size(); i++)
        {
            goodsList.get(i).print();
        }

    }

    void sortByName()
    {
       Collections.sort(goodsList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        for(int i = 0; i<goodsList.size(); i++)
        {
            goodsList.get(i).print();
        }
    }

    void sortByAmount()
    {
       Collections.sort(goodsList, new ComparatorByAmount());
        for(int i = 0; i<goodsList.size(); i++)
        {
            goodsList.get(i).print();
        }
    }

    void max()
    {
        Collections.max(goodsList, new MaxComparator()).print();

    }

}
