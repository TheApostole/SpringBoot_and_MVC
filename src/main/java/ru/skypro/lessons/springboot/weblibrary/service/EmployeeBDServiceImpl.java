package ru.skypro.lessons.springboot.weblibrary.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.exceptions.EmployeeNotFoundExceptions;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeBDRepository;
import ru.skypro.lessons.springboot.weblibrary.util.UtilitiesMethods;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service

public class EmployeeBDServiceImpl implements EmployeeBDService {
    private final EmployeeBDRepository employeeBDRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportFileServiceImpl.class);

    @Override
    public List<Employee> getEmployeeByPositionName(String name) {
        LOGGER.info("Был вызван метод для получения списка сотрудников на должности {}", name);
        LOGGER.debug("Успешно");
        return employeeBDRepository.findAllEmployeeFullInfo(name).stream().collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        LOGGER.info("Был вызван метод для получения сотрудника с id = {}", id);
        return employeeBDRepository.findById(id).map(EmployeeDTO::toDTO).orElseThrow(EmployeeNotFoundExceptions::new);
    }

    @Override
    public List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage) {
        LOGGER.info("Был вызван метод для получения информации о сотрудниках из страницы = {}", pageIndex);
        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, unitPerPage);
        return employeeBDRepository.findAll(employeeOfConcretePage).stream().toList();
    }

    public Employee getEmployeeWithHighestSalary() {
        LOGGER.info("Был вызван метод для получения сотрудника с самой высокой зарплатой");
        return employeeBDRepository.getEmployeeWithHighestSalary();
    }

    @Override
    public void upload(Class<MultipartFile> jsonFile) throws IOException {
        LOGGER.info("Был вызван метод для получения списка сотрудников и сохранения их в базе данных");
        String fileName = jsonFile.getName();
        String jsonContent = UtilitiesMethods.readTextFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeDTO employeeDTO = objectMapper.readValue(jsonContent, EmployeeDTO.class);
        List<Employee> employeeList = List.of(employeeDTO.toEmployee());
        employeeBDRepository.saveAll(employeeList);
        LOGGER.debug("Успешно");
    }

}