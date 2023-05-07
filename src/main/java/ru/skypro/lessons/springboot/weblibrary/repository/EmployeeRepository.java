package ru.skypro.lessons.springboot.weblibrary.repository;

import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    Integer getSumSalary();
    Employee getMinSalary();
    Employee getMaxSalary();
    List<Employee> getHighSalary();
}
