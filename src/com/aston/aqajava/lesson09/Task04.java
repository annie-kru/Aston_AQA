package com.aston.aqajava.lesson09;

import java.util.*;
import java.util.stream.Collectors;

public class Task04 {

    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий",17,Gender.MAN),
                new Student("Максим",20,Gender.MAN),
                new Student("Екатерина",20,Gender.WOMAN),
                new Student("Михаил",28,Gender.MAN)
        );
        System.out.println("Средний возраст студентов мужского пола: " + averageAge(students));
        System.out.println("Повестку в армию получат следующие студенты: ");
        for(Object student : summonsToArmy(students)){
            System.out.println(student);
        }
    }
    public static double averageAge(Collection<Student> students){
        return students.stream()
                .filter((student) -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average().getAsDouble();
    }
    public static List summonsToArmy(Collection<Student> students){
       return students.stream()
               .filter((s)-> s.getAge() >= 18 && s.getAge() < 27 && s.getGender() == Gender.MAN)
               .collect(Collectors.toList());
    }

    private enum Gender {
        MAN, WOMAN
    }
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) && Objects.equals(age, student.age) && gender == student.gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}
