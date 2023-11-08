package com.aston.aqajava.lesson06;

import java.io.*;

public class FileCommands {
    public static void save (AppData data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/data.csv"))) {
            String[] header = data.getHeader();
            for(int i = 0; i < header.length; i++){
                writer.write(header[i]);
                if (i < header.length - 1) {
                    writer.write(";");
                }
            }
            writer.newLine();

            int values[][] = data.getData();
            for (int i = 0; i < values.length; i++){
                for(int j = 0; j < values[i].length; j++){
                    writer.write(String.valueOf(values[i][j]));
                    if (j < values[i].length - 1) {
                        writer.write(";");
                    }
                }
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printFile(AppData data){
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/data.csv"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
