package ru.skypro.lessons.springboot.weblibrary.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import lombok.Getter;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeBDService;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Getter
@AllArgsConstructor

public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeBDService employeeBDService;

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

    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable Integer id) {
        return employeeService.getEmployeeByID(id);
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(@RequestParam("salary") Integer salary) {
        return employeeService.getEmployeesWhoseSalaryIsHigherThanTheParameter(salary);
    }

    @GetMapping("/withHighestSalary")
    public Employee getEmployeeWithHighestSalary() {
        return employeeBDService.getEmployeeWithHighestSalary();
    }

    @GetMapping("/")
    public Position getEmployeeByPositionName(@RequestParam String name) {
        return employeeBDService.getEmployeeByPositionName(name);
    }

    @GetMapping("/{id}/fullInfo")
    public Employee getEmployeesById(@PathVariable int id) {
        return employeeBDService.getEmployeeById(id);
    }

    @GetMapping("/page")
    public List<Employee> getEmployeeWithPaging(@RequestParam int pageIndex,@RequestParam int unitPerPage) {
        return employeeBDService.getEmployeeWithPaging(pageIndex, unitPerPage);
    }

}