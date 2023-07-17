package ru.skypro.lessons.springboot.weblibrary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeNoBD;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepositoryImpl;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepositoryImpl employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void getSumSalaryTestOnTheReturnedResultAndToTheMethodCall () {
        int sum = 0;
        assertEquals(sum, employeeService.getSumSalary());
        verify(employeeRepository, only())
                .getSumSalary();
    }

    @Test
    public void getMinSalaryTestOnTheReturnedResult () {
        EmployeeNoBD expected = new EmployeeNoBD();
        lenient().when(employeeRepository.getMinSalary())
                .thenReturn(expected);
        assertEquals(expected, employeeService.getMinSalary());
    }

    @Test
    public void getMaxSalaryTestOnTheReturnedResult () {
        EmployeeNoBD employeeNoBD = new EmployeeNoBD();
        lenient().when(employeeRepository.getMaxSalary())
                .thenReturn(employeeNoBD);
        assertEquals(employeeNoBD, employeeService.getMaxSalary());
    }

    @Test
    public void getHighSalaryTestOnTheReturnedResult () {
        List<EmployeeNoBD> expected = new ArrayList<>();
        lenient().when(employeeRepository.getHighSalary())
                .thenReturn(expected);
        assertEquals(expected, employeeService.getHighSalary());
    }

    @Test
    public void createEmployeeTestCallMethod () {
        EmployeeNoBD expected = new EmployeeNoBD();
        verify(employeeRepository, never())
                .createEmployee(expected);
    }

    @Test
    public void editEmployeeTestOnTheReturnedResult () {
        List<EmployeeNoBD> expected = new ArrayList<>();
        int id = 0;
        String name = String.valueOf(String.class);
        int salary = 0;
        lenient().when(employeeRepository.editEmployee(id,name, salary))
                .thenReturn(expected);
        assertEquals(expected, employeeService.editEmployee(id,name, salary));
    }

    @Test
    public void getEmployeeByIDTestOnTheReturnedResult () {
        EmployeeNoBD expected = new EmployeeNoBD();
        int id = 0;
        lenient().when(employeeRepository.getEmployeeByID(id))
                .thenReturn(expected);
        assertEquals(expected, employeeService.getEmployeeByID(id));
    }

    @Test
    public void deleteEmployeeByIDTestCallMethod () {
        int id = 0;
        verify(employeeRepository, never())
                .deleteEmployeeByID(id);
    }

    @Test
    public void getEmployeesWhoseSalaryIsHigherThanTheParameterTestOnTheReturnedResult () {
        List<EmployeeNoBD> expected = new ArrayList<>();
        int salary = 0;
        lenient().when(employeeRepository.getEmployeesWhoseSalaryIsHigherThanTheParameter(salary))
                .thenReturn(expected);
        assertEquals(expected, employeeService.getEmployeesWhoseSalaryIsHigherThanTheParameter(salary));
    }
}