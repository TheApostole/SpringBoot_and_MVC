package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.util.*;

import static java.util.Comparator.comparingInt;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {


     List<Employee> employeeList = List.of(
            new Employee("Санёк", 94_000, 1),
            new Employee("Дикий", 175_000, 2),
            new Employee("Алексей", 45_000, 3),
            new Employee("Алёна", 106_000, 4));

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
    public void createEmployee(Employee employee){
                employeeList.add(employee);
    }
    public List<Employee> editEmployee(Integer id, String name, Integer salary) {
    for (Employee item : employeeList) {
        if (id == item.getId()) {
            item.setName(name);
            item.setSalary(salary);
        }
    }
    return employeeList;
    }
    public Employee getEmployeeByID(Integer id) {
        Employee employee = new Employee();
        for (Employee empl : employeeList) {
            if (id == empl.getId())
                employee = empl;
        }
        return employee;
    }
    public void deleteEmployeeByID(Integer id) {
        employeeList.removeIf(employee -> employee.getId() == id);
    }
    public List <Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if(employee.getSalary() > salary) {
                employees.add(employee);
            }
        }
        return employees;
    }
}
