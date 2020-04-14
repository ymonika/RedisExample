package com.example.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    int id;
    String name;
    String lName;

    public Employee(int id, String name, String lName) {
        this.id = id;
        this.name = name;
        this.lName = lName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee(1, "Monika", "Yewale"), new Employee(1, "Monika", "as"),
                new Employee(3, "Priya", "Gunjal"), new Employee(4, "Priya", "Yewale"),
                new Employee(5, "Vishal", "Yewale"));


        System.out.println(employees.stream().collect(
                Collectors.groupingBy(Employee::getName,
                        Collectors.mapping(Employee::getId, Collectors.toSet()))));

    }
}
