package com.aston.aqajava.lesson04;
public class Park {
    private String parkName;
    public class Attractions{
        private String attractionName;
        private String openHours;
        private double price;

        public void info(){
            System.out.println("Данные об аттракционе: " + getAttractionName()
            + "\nВремя работы: " + getOpenHours()
            + "\nСтоимость: " + getPrice());
        }
        public String getAttractionName() {
            return attractionName;
        }

        public void setAttractionName(String attractionName) {
            this.attractionName = attractionName;
        }

        public String getOpenHours() {
            return openHours;
        }

        public void setOpenHours(String openHours) {
            this.openHours = openHours;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
