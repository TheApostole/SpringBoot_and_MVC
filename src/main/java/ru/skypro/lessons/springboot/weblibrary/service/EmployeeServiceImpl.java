package ru.skypro.lessons.springboot.weblibrary.service;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeNoBD;
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
    public EmployeeNoBD getMinSalary() {
        LOGGER.info("Был вызван метод для получения минимальной зарплаты у сотрудников");
        return employeeRepository.getMinSalary();
    }
    public EmployeeNoBD getMaxSalary() {
        LOGGER.info("Был вызван метод для получения максимальной зарплаты у сотрудников");
        return employeeRepository.getMaxSalary();
    }
    public List<EmployeeNoBD> getHighSalary() {
        LOGGER.info("Был вызван метод для получения сотрудников, зарплата которых выше средней");
        return employeeRepository.getHighSalary();
    }
    public void createEmployee(EmployeeNoBD employee) {
        LOGGER.info("Был вызван метод для создания сотрудника {}" , employee);
        employeeRepository.createEmployee(employee);
    }
    public List<EmployeeNoBD> editEmployee(Integer id, String name, Integer salary) {
        LOGGER.info("Был вызван метод для редактирования информации о сотруднике с id = {}", id);
       return employeeRepository.editEmployee(id, name, salary);
    }
    public EmployeeNoBD getEmployeeByID(Integer id) {
        LOGGER.info("Был вызван метод для получения сотрудника по id = {}", id);
        return employeeRepository.getEmployeeByID(id);
    }
    public void deleteEmployeeByID(Integer id) {
        LOGGER.info("Был вызван метод для удаления сотрудника по id = {}", id);
        employeeRepository.deleteEmployeeByID(id);
    }
    public List<EmployeeNoBD> getEmployeesWhoseSalaryIsHigherThanTheParameter(Integer salary) {
        LOGGER.info("Был вызван метод для получения сотрудников, зарплата которых выше {} р", salary);
        return employeeRepository.getEmployeesWhoseSalaryIsHigherThanTheParameter(salary);
    }

}
