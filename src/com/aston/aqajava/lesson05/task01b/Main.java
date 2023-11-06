package com.aston.aqajava.lesson05.task01b;

public class Main {

    public static void main(String[] args) {

        Cat[] allCats = new Cat[4];
        allCats[0] = new Cat("Sally", 5);
        allCats[1] = new Cat("Lucy", 30);
        allCats[2] = new Cat("Danny", 10);
        allCats[3] = new Cat("Koby", 5);


        Plate plate = new Plate(60);

        for (int i = 0; i < allCats.length; i++) {
            allCats[i].eat(plate);
            if (allCats[i].getFullness()){
                System.out.println(allCats[i].getName() + " ate.");
            } else {
                System.out.println(allCats[i].getName() + " didn't ate.");
            }
        }
        plate.info();
    }
}
