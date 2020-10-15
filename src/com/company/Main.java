package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Item i1 = new Item("Pomidor", ItemCondition.NEW, 10, 15);
	Item i2 = new Item("Morela", ItemCondition.USED, 15, 20);
	Item i3 = new Item("Spodnie", ItemCondition.REFURBISHED, 5, 45);
	Item i4 = new Item("Meble", ItemCondition.USED, 100, 5);
	Item i5 = new Item("Pomidor", ItemCondition.NEW, 20, 25);
	Item i6 = new Item("Pomidor", ItemCondition.USED, 20, 5);
	Item i7 = new Item("Krzesło", ItemCondition.REFURBISHED,10, 1);
	//FulfillmentCenter magazyn1 = new FulfillmentCenter("Magazyn 1", 6000);
	List<Item> list1 = new ArrayList<>();
	list1.add(i1);
	list1.add(i2);
	List<Item> list2 = new ArrayList<>();
	list2.add(i3);
	list2.add(i4);
	List<Item> list3 = new ArrayList<>();
	list3.add(i5);
	list3.add(i6);
	List<Item> list4 = new ArrayList<>();
	//magazyn1.addProduct(i1);
	//magazyn1.addProduct(i4);
	//magazyn1.addProduct(i5);
	//magazyn1.addProduct(i7);
	//magazyn1.summary();
	//System.out.println("-------------------");
	//magazyn1.getProduct(i2);
	//magazyn1.getProduct(i7);
	//magazyn1.summary();
	//System.out.println("-------------------");
	//magazyn1.removeProduct(i2);
	//magazyn1.summary();
	//System.out.println("-------------------");
	//magazyn1.search("Morela");
	//System.out.println("-------------------");
	//magazyn1.searchPartial("do");
	//System.out.println("-------------------");
	//magazyn1.countByCondition(ItemCondition.USED);
	//System.out.println("-------------------");
	//magazyn1.sortByName();
	//System.out.println("-------------------");
	//magazyn1.sortByAmount();
	//System.out.println("-------------------");
	//magazyn1.max();

        FulfillmentCenterContainer fulfillmentCenterContainer = new FulfillmentCenterContainer("Zbiór");

        fulfillmentCenterContainer.addCenter("magazyn 2",list1, 10000);
        fulfillmentCenterContainer.addCenter("magazyn 3",list2, 6000);
        fulfillmentCenterContainer.addCenter("magazyn 4", list4, 5000);

        fulfillmentCenterContainer.summary();
		System.out.println("-------------------");
        List<FulfillmentCenter> listFC = fulfillmentCenterContainer.findEmpty();
		for( FulfillmentCenter fc : listFC )
		{
			fc.summary();
		}
		System.out.println("-------------------");
        fulfillmentCenterContainer.removeCenter("magazyn 3");
        fulfillmentCenterContainer.summary();
    }
}
