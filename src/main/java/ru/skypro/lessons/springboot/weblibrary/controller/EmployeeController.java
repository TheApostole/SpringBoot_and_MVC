package ru.skypro.lessons.springboot.weblibrary.controller;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import lombok.Getter;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employees")
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
    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    public List<Employee> editEmployee(@PathVariable Integer id, String name, Integer salary) {
        return employeeService.editEmployee(id, name, salary);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable Integer id) {
        return employeeService.getEmployeeByID(id);
    }
    @DeleteMapping("/delete{id}")
    public void deleteEmployeeByID(@PathVariable Integer id) {
        employeeService.deleteEmployeeByID(id);
    }
    @GetMapping("/salaryHigherThan")
    public List<Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(@RequestParam("salary") Integer salary) {
        return employeeService.getEmployeesWhoseSalaryIsHigherThanTheParameter(salary);
    }
}