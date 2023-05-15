package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.util.*;

import static java.util.Comparator.comparingInt;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee("Санёк", 94_000),
            new Employee("Дикий", 175_000),
            new Employee("Алексей", 45_000),
            new Employee("Алёна", 106_000));

    @Override
    public Integer getSumSalary() {
        List<Integer> salary = new ArrayList<>();
        for (Employee employee : employeeList)
            salary.add(employee.getSalary());
        return salary.stream().mapToInt(Integer::intValue).sum();
    }
    @Override
    public Employee getMinSalary() {
        return employeeList.stream()
                .min(comparingInt(Employee::getSalary))
                .get();
    }
    @Override
    public Employee getMaxSalary() {
        return employeeList.stream()
                .max(comparingInt(Employee::getSalary))
                .get();
    }
    @Override
    public List <Employee> getHighSalary() {
        List<Integer> salary = new ArrayList<>();
        for (Employee employee : employeeList)
            salary.add(employee.getSalary());
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList)
            if(employee.getSalary() > salary.stream()
                .mapToInt(a -> a)
                .average().orElse(0)){
                employees.add(employee);
            }
        return employees;
    }






}
