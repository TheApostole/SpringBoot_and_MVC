package ru.skypro.lessons.springboot.weblibrary.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Getter;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Getter
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/salary/sum")
    public Integer getSumSalaryEmployees() {
        return employeeService.getSumSalary();
    }
    @GetMapping("/salary/min")
    public Employee getMinSalary() {
        return employeeService.getMinSalary();
    }
    @GetMapping("/salary/max")
    public Employee getMaxSalary() {
        return employeeService.getMaxSalary();
    }
    @GetMapping("/high-salary")
    public List<Employee> getHighSalary() {
        return employeeService.getHighSalary();
    }
}