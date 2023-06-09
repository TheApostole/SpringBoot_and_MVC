package ru.skypro.lessons.springboot.weblibrary.repository;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import java.util.List;

public interface EmployeeRepository {

    Integer getSumSalary();
    Employee getMinSalary();
    Employee getMaxSalary();
    List<Employee> getHighSalary();
    void createEmployee(Employee employee);
    List<Employee> editEmployee(Integer id, String name, Integer salary);
    Employee getEmployeeByID(Integer id);
    void deleteEmployeeByID(Integer id);
    List<Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary);

}
