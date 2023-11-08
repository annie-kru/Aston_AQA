package com.aston.aqajava.lesson06;

import java.util.Random;

import static com.aston.aqajava.lesson06.FileCommands.printFile;
import static com.aston.aqajava.lesson06.FileCommands.save;

public class Main {
    public static void main(String[] args){
       String[] headers = new String[] {"Value 1", "Value 2", "Value 3"};
       int[][] data = new int[5][3];
        Random rand = new Random();

       for (int i = 0; i < data.length; i++){
           for(int j = 0; j < data[i].length; j++){
               data[i][j] = rand.nextInt(999);
           }
       }

       AppData table = new AppData(headers, data);

       save(table);
       printFile(table);
    }
}
