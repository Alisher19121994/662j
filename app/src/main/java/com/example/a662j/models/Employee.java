package com.example.a662j.models;

public class Employee {

    int id;
    String employee_name;
    int employee_salary;
    int employee_age;
    String profile_image;

    public Employee(int id, String employee_name, int employee_salary, int employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public int getId() {
        return id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public String getProfile_image() {
        return profile_image;
    }
}
