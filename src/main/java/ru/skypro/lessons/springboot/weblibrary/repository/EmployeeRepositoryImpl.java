package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeNoBD;
import ru.skypro.lessons.springboot.weblibrary.dto.PositionNoBD;

import java.util.*;

import static java.util.Comparator.comparingInt;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

     List<EmployeeNoBD> employeeList = List.of(
            new EmployeeNoBD(1, "Санёк", 94_000, new PositionNoBD(1, "Рабочий")),
            new EmployeeNoBD(2, "Дикий", 175_000, new PositionNoBD(2,"Рабочий")),
            new EmployeeNoBD(3, "Алексей", 45_000, new PositionNoBD(3,"Рабочий")),
            new EmployeeNoBD(4, "Алёна", 106_000, new PositionNoBD(4,"Рабочий")));


    @Override
    public Integer getSumSalary() {
        List<Integer> salary = new ArrayList<>();
        for (EmployeeNoBD employeeNoBD : employeeList)
            salary.add(employeeNoBD.getSalary());
        return salary.stream().mapToInt(Integer::intValue).sum();
    }
    @Override
    public EmployeeNoBD getMinSalary() {
        return employeeList.stream()
                .min(comparingInt(EmployeeNoBD::getSalary))
                .get();
    }
    @Override
    public EmployeeNoBD getMaxSalary() {
        return employeeList.stream()
                .max(comparingInt(EmployeeNoBD::getSalary))
                .get();
    }
    @Override
    public List<EmployeeNoBD> getHighSalary() {
        List<Integer> salary = new ArrayList<>();
        for (EmployeeNoBD employee : employeeList)
            salary.add(employee.getSalary());
        List<EmployeeNoBD> employees = new ArrayList<>();
        for (EmployeeNoBD employee : employeeList)
            if(employee.getSalary() > salary.stream()
                .mapToInt(a -> a)
                .average().orElse(0)){
                employees.add(employee);
            }
        return employees;
    }
    public void createEmployee(EmployeeNoBD employee){
                employeeList.add(employee);
    }
    public List<EmployeeNoBD> editEmployee(Integer id, String name, Integer salary) {
    for (EmployeeNoBD item : employeeList) {
        if (Objects.equals(id, item.getId())) {
            item.setName(name);
            item.setSalary(salary);
        }
    }
    return employeeList;
    }
    public EmployeeNoBD getEmployeeByID(Integer id) {
        EmployeeNoBD employee = new EmployeeNoBD();
        for (EmployeeNoBD empl : employeeList) {
            if (Objects.equals(id, empl.getId()))
                employee = empl;
        }
        return employee;
    }
    public void deleteEmployeeByID(Integer id) {
        employeeList.removeIf(employee -> Objects.equals(employee.getId(), id));
    }
    public List<EmployeeNoBD> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary) {
        List<EmployeeNoBD> employees = new ArrayList<>();
        for (EmployeeNoBD employee : employeeList) {
            if(employee.getSalary() > salary) {
                employees.add(employee);
            }
        }
        return employees;
    }
}
