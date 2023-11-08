package com.aston.aqajava.lesson06;

import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;
    public AppData(String[] header, int[][] data){
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppData appData = (AppData) o;
        return Arrays.equals(header, appData.header) && Arrays.equals(data, appData.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(header);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
