package com.aston.aqajava.lesson04;

public class Main {
    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];

        persArray[0] = new Employee("Иванов Иван", "Инженер", "mail1@mail.com",
                "80297123456", 3000, 37);
        persArray[1] = new Employee("Петров Иван", "Инженер", "mail2@mail.com",
                "80297123456", 3000, 45);
        persArray[2] = new Employee("Смирнова Татьяна", "Бухгалтер", "mail3@mail.com",
                "80297123456", 3000, 29);
        persArray[3] = new Employee("Морошка Павел", "Проектировщик", "mail4@mail.com",
                "80297123456", 3000, 30);
        persArray[4] = new Employee("Еремина Ирина", "Секретарь", "mail5@mail.com",
                "80297123456", 3000, 41);

        for(int i = 0; i < persArray.length; i++){
            if (persArray[i].getAge() > 40){
                persArray[i].employeeInfo();
                System.out.println("-------");
            }
        }
    }
}
