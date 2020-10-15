package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> fc = new TreeMap<String, FulfillmentCenter>();
    String containerName;

    FulfillmentCenterContainer(String name)
    {
        containerName = name;
    }

    void addCenter(String name, List<Item> list, double capacity)
    {

        fc.put(name, new FulfillmentCenter(name,list, capacity));
    }

    void removeCenter(String name)
    {
        fc.remove(name);
    }

    List findEmpty() {
        List<FulfillmentCenter> emptyFulfillment = new ArrayList<>();
        for (Map.Entry<String, FulfillmentCenter> fcEntry : fc.entrySet()) {
            final FulfillmentCenter value = fcEntry.getValue();
            if (value.totalMass == 0) {
                emptyFulfillment.add((value));
            }

        }
        return emptyFulfillment;
    }

    void summary()
    {
        System.out.println("Dane magazynów");
        for(Map.Entry<String, FulfillmentCenter> fcEntry : fc.entrySet()){
            final String key = fcEntry.getKey();
            final FulfillmentCenter value = fcEntry.getValue();

            double percent = (value.totalMass/value.capacity)*100;

            System.out.println("Nazwa magazynu: "+key);
            System.out.println("Pojemność: "+percent);
        }
    }

}
