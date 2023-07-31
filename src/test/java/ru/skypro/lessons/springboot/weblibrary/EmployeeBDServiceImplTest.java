package ru.skypro.lessons.springboot.weblibrary;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundExceptions;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeBDRepository;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeBDServiceImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeBDServiceImplTest {

    @Mock
    private EmployeeBDRepository employeeBDRepository;

    @InjectMocks
    private EmployeeBDServiceImpl employeeBDService;

    @Test
    public void getEmployeeByPositionNameTestWhenTheResultIsReturned () {
        String name = String.valueOf(String.class);
        Optional<Employee> employeeOptional = Optional.empty();
        when(employeeBDRepository.findAllEmployeeFullInfo(name))
                .thenReturn(employeeOptional);
        assertEquals(anyList(), employeeBDService.getEmployeeByPositionName(name));

    }

    @Test
    public void getEmployeeByIdTestWhenTheResultIsReturned () {
        Optional<Employee> employeeOptional = Optional.empty();
        lenient().when(employeeBDRepository.findById(anyInt()))
                .thenReturn(employeeOptional);
    }

    @Test
    public void getEmployeeWithPagingTestWhenTheResultIsReturned () {
        int pageIndex = 1;
        int unitPerPage = 1;
        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, unitPerPage);
        Page<Employee> page = Page.empty();
        lenient().when(employeeBDRepository.findAll(employeeOfConcretePage))
                .thenReturn(page);
        assertEquals(anyList(), employeeBDService.getEmployeeWithPaging(pageIndex, unitPerPage));
    }

    @Test
    public void getEmployeeWithHighestSalaryTestWhenTheResultIsReturned () {
        Employee employee = new Employee();
        lenient().when(employeeBDRepository.findAll())
                .thenReturn(Collections.singleton(employee));
    }

    @SneakyThrows
    @Test
    public void uploadNegativeTest () {
        MockMultipartFile multipartFile = new MockMultipartFile(
                "fileEmployees",
                "employees.json",
                MediaType.APPLICATION_JSON_VALUE,
                EmployeeControllerTest.class.getResourceAsStream("/employees.json"));
        lenient().doThrow(EmployeeNotFoundExceptions.class)
                .when(employeeBDRepository).saveAll(anyList());
        assertThrows(IOException.class, ()-> employeeBDService.upload(multipartFile));
    }
}
