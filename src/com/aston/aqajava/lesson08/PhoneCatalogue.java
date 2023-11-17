package com.aston.aqajava.lesson08;

import java.util.*;

public class PhoneCatalogue {
    private HashMap<String,String> catalogue;
    public PhoneCatalogue() {
        this.catalogue = new HashMap<>();
    }
    public void add(String lastName, String number) {
        if (catalogue.containsKey(number)) {
            System.out.println("Phone number already exists.");
        }
        else {
            catalogue.put(number, lastName);
        }
    }
    public void get(String lastname){
        ArrayList list = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = catalogue.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue() == lastname){
                list.add(entry.getKey());
            }
        }
        if (list.isEmpty()){
            System.out.println(lastname + " has no registered phone numbers.");
        } else{
            System.out.println("Phone numbers for " + lastname + " are " + list);
        }
    }
}
