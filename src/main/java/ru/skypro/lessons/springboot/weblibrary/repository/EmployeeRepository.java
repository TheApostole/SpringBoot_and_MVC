package ru.skypro.lessons.springboot.weblibrary.repository;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeNoBD;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import java.util.List;

public interface EmployeeRepository {

    Integer getSumSalary();
    EmployeeNoBD getMinSalary();
    EmployeeNoBD getMaxSalary();
    List<EmployeeNoBD> getHighSalary();
    void createEmployee(EmployeeNoBD employee);
    List<EmployeeNoBD> editEmployee(Integer id, String name, Integer salary);
    EmployeeNoBD getEmployeeByID(Integer id);
    void deleteEmployeeByID(Integer id);
    List<EmployeeNoBD> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary);

}
