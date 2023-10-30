package com.aston.aqajava.lesson04;

import java.util.Objects;

public class Employee {
    private String name;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    Employee(String name, String jobTitle, String email, String phoneNumber, double salary, int age){
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public  void employeeInfo() {
        System.out.println("Данные о сотруднике: " + getName()
        + "\nДолжность: " + getJobTitle()
        + "\nEmail: " + getEmail()
        + "\nНомер телефона: " + getPhoneNumber()
        + "\nЗаработная плата: " + getSalary()
        + "\nВозраст: " + getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(email, employee.email) && Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, jobTitle, email, phoneNumber, salary, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
