package ru.skypro.lessons.springboot.weblibrary.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import java.util.List;

@AllArgsConstructor
@Service

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Integer getSumSalary() {
        return employeeRepository.getSumSalary();
    }
    public Employee getMinSalary() {
        return employeeRepository.getMinSalary();
    }
    public Employee getMaxSalary() {
        return employeeRepository.getMaxSalary();
    }
    public List<Employee> getHighSalary() {
        return employeeRepository.getHighSalary();
    }
    public void createEmployee(Employee employee) {
        employeeRepository.createEmployee(employee);
    }
    public List<Employee> editEmployee(Integer id, String name, Integer salary){
       return employeeRepository.editEmployee(id, name, salary);
    }
    public Employee getEmployeeByID(Integer id) {
        return employeeRepository.getEmployeeByID(id);
    }
    public void deleteEmployeeByID(Integer id) {
        employeeRepository.deleteEmployeeByID(id);
    }
    public List<Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary){
        return employeeRepository.getEmployeesWhoseSalaryIsHigherThanTheParameter(salary);
    }

}
