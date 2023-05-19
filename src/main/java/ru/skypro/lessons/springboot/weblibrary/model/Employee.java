package ru.skypro.lessons.springboot.weblibrary.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String name;
    private int salary;
//    private static int count;
    private int id;

    public Employee() {

    }
//    public Employee(String name, int salary) {
//        this.name = name;
//        this.salary = salary;
//        id = ++count;
//    }
}
