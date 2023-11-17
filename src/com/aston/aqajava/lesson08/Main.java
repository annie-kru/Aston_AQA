package com.aston.aqajava.lesson08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] wordsArray = new String[]{"Mariehamn","Tirana","Vienna","Prague","Tallinn","Tirana","Zagreb",
                "Prague","Paris","Helsinki","Tallinn","Athens","Berlin","Budapest","Reykjavík","Tallinn","Berlin",
                "Helsinki","Douglas","Douglas"};
        System.out.println("Unique words are: " + uniqueWordsList(wordsArray));
        System.out.println(wordRepetitionCount(wordsArray));



        PhoneCatalogue catalogue = new PhoneCatalogue();
        catalogue.add("Smith", "+375 29 111-11-11");
        catalogue.add("Johnson", "+375 29 111-11-12");
        catalogue.add("Williams", "+375 29 111-11-13");
        catalogue.add("Smith", "+375 29 111-11-14");
        catalogue.add("Garcia", "+375 29 111-11-15");
        catalogue.add("Williams", "+375 29 111-11-16");
        catalogue.add("Smith", "+375 29 111-11-17");
        catalogue.add("Jones", "+375 29 111-11-18");
        catalogue.add("Wilson", "+375 29 111-11-19");
        catalogue.add("Davis", "+375 29 111-11-21");

        catalogue.get("Davis");
    }
    public static HashMap<String,Integer> wordRepetitionCount(String[] array){
        HashMap<String,Integer> wordRepetitionCount = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if (wordRepetitionCount.containsKey(array[i])){
                int counter = wordRepetitionCount.get(array[i]);
                wordRepetitionCount.put(array[i],counter + 1);
            } else {
                wordRepetitionCount.put(array[i],1);
            }
        }
        return wordRepetitionCount;
    }
    public static ArrayList uniqueWordsList(String[] array){
        HashMap<String,Integer> uniqueWordsList = wordRepetitionCount(array);
        ArrayList list = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> iterator = uniqueWordsList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}