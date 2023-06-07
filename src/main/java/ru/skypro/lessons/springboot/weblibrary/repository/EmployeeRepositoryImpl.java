package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import java.util.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Integer getSumSalary() {
        return null;
    }

    @Override
    public Employee getMinSalary() {
        return null;
    }

    @Override
    public Employee getMaxSalary() {
        return null;
    }

    @Override
    public List<Employee> getHighSalary() {
        return null;
    }

    @Override
    public void createEmployee(Employee employee) {
    }

    @Override
    public List<Employee> editEmployee(Integer id, String name, Integer salary) {
        return null;
    }

    @Override
    public Employee getEmployeeByID(Integer id) {
        return null;
    }

    @Override
    public void deleteEmployeeByID(Integer id) {

    }

    @Override
    public List<Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary) {
        return null;
    }

//     List<Employee> employeeList = List.of(
//            new Employee(1, "Санёк", 94_000, new Position(1, "Рабочий")),
//            new Employee(2, "Дикий", 175_000, "Рабочий"),
//            new Employee(3, "Алексей", 45_000, "Рабочий"),
//            new Employee(4, "Алёна", 106_000, "Рабочий"));
//
//
//    @Override
//    public Integer getSumSalary() {
//        List<Integer> salary = new ArrayList<>();
//        for (Employee employee : employeeList)
//            salary.add(employee.getSalary());
//        return salary.stream().mapToInt(Integer::intValue).sum();
//    }
//    @Override
//    public Employee getMinSalary() {
//        return employeeList.stream()
//                .min(comparingInt(Employee::getSalary))
//                .get();
//    }
//    @Override
//    public Employee getMaxSalary() {
//        return employeeList.stream()
//                .max(comparingInt(Employee::getSalary))
//                .get();
//    }
//    @Override
//    public List <Employee> getHighSalary() {
//        List<Integer> salary = new ArrayList<>();
//        for (Employee employee : employeeList)
//            salary.add(employee.getSalary());
//        List<Employee> employees = new ArrayList<>();
//        for (Employee employee : employeeList)
//            if(employee.getSalary() > salary.stream()
//                .mapToInt(a -> a)
//                .average().orElse(0)){
//                employees.add(employee);
//            }
//        return employees;
//    }
//    public void createEmployee(Employee employee){
//                employeeList.add(employee);
//    }
//    public List<Employee> editEmployee(Integer id, String name, Integer salary) {
//    for (Employee item : employeeList) {
//        if (id == item.getId()) {
//            item.setName(name);
//            item.setSalary(salary);
//        }
//    }
//    return employeeList;
//    }
//    public Employee getEmployeeByID(Integer id) {
//        Employee employee = new Employee();
//        for (Employee empl : employeeList) {
//            if (id == empl.getId())
//                employee = empl;
//        }
//        return employee;
//    }
//    public void deleteEmployeeByID(Integer id) {
//        employeeList.removeIf(employee -> employee.getId() == id);
//    }
//    public List <Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary) {
//        List<Employee> employees = new ArrayList<>();
//        for (Employee employee : employeeList) {
//            if(employee.getSalary() > salary) {
//                employees.add(employee);
//            }
//        }
//        return employees;
//    }
}
