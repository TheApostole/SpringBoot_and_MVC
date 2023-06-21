package ru.skypro.lessons.springboot.weblibrary.service;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;
import java.util.List;

@AllArgsConstructor
@Service

public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    public Integer getSumSalary() {
        LOGGER.info("Был вызван метод для получения суммы зарплат сотрудников");
        return employeeRepository.getSumSalary();
    }
    public Employee getMinSalary() {
        LOGGER.info("Был вызван метод для получения минимальной зарплаты у сотрудников");
        return employeeRepository.getMinSalary();
    }
    public Employee getMaxSalary() {
        LOGGER.info("Был вызван метод для получения максимальной зарплаты у сотрудников");
        return employeeRepository.getMaxSalary();
    }
    public List<Employee> getHighSalary() {
        LOGGER.info("Был вызван метод для получения сотрудников, зарплата которых выше средней");
        return employeeRepository.getHighSalary();
    }
    public void createEmployee(Employee employee) {
        LOGGER.info("Был вызван метод для создания сотрудника {}" , employee);
        employeeRepository.createEmployee(employee);
    }
    public List<Employee> editEmployee(Integer id, String name, Integer salary) {
        LOGGER.info("Был вызван метод для редактирования информации о сотруднике с id = {}", id);
       return employeeRepository.editEmployee(id, name, salary);
    }
    public Employee getEmployeeByID(Integer id) {
        LOGGER.info("Был вызван метод для получения сотрудника по id = {}", id);
        return employeeRepository.getEmployeeByID(id);
    }
    public void deleteEmployeeByID(Integer id) {
        LOGGER.info("Был вызван метод для удаления сотрудника по id = {}", id);
        employeeRepository.deleteEmployeeByID(id);
    }
    public List<Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary) {
        LOGGER.info("Был вызван метод для получения сотрудников, зарплата которых выше {} р", salary);
        return employeeRepository.getEmployeesWhoseSalaryIsHigherThanTheParameter(salary);
    }

}
