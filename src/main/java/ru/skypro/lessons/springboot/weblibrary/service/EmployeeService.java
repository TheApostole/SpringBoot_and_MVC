package ru.skypro.lessons.springboot.weblibrary.service;

import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.util.List;

public interface EmployeeService {

    Integer getSumSalary();
    Employee getMinSalary();
    Employee getMaxSalary();
    List<Employee> getHighSalary();
}
