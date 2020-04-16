package com.example.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    int id;
    String name;
    String lName;

    public Person(int id, String name, String lName) {
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
        List<Person> people = Arrays.asList(new Person(1, "Monika", "Yewale"), new Person(1, "Monika", "as"),
                new Person(3, "Priya", "Gunjal"), new Person(4, "Priya", "Yewale"),
                new Person(5, "Vishal", "Yewale"));


        System.out.println(people.stream().collect(
                Collectors.groupingBy(Person::getName,
                        Collectors.mapping(Person::getId, Collectors.toSet()))));

    }
}
