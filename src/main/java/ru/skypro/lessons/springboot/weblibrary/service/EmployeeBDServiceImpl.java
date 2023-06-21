package ru.skypro.lessons.springboot.weblibrary.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeBDRepository;
import ru.skypro.lessons.springboot.weblibrary.util.UtilitiesMethods;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class EmployeeBDServiceImpl implements EmployeeBDService {

    private final EmployeeBDRepository employeeBDRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportFileServiceImpl.class);

    @Override
    public Position getEmployeeByPositionName(String name) {
        LOGGER.info("Был вызван метод для получения списка сотрудников на должности {}", name);
        if (name.equals(" ")) {
            employeeBDRepository.findAllEmployeeFullInfo();
        }
        LOGGER.debug("Успешно");
        return employeeBDRepository.findByName(name).get(0).getPosition();
    }

    @Override
    public Employee getEmployeeById(int id) {
        LOGGER.info("Был вызван метод для получения сотрудника с id = {}", id);
        Optional<Employee> employeeOptional = employeeBDRepository.findById(id);
        LOGGER.debug("Успешно");
        return employeeOptional.orElseThrow(() -> new IncorrectResultSizeDataAccessException(id));
    }

    @Override
    public List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage) {
        LOGGER.info("Был вызван метод для получения информации о сотрудниках из страницы = {}", pageIndex);
        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, unitPerPage);
        Page<Employee> page = employeeBDRepository.findAll(employeeOfConcretePage);
        LOGGER.debug("Успешно");
        return page.stream().toList();
    }

    public Employee getEmployeeWithHighestSalary() {
        LOGGER.info("Был вызван метод для получения сотрудника с самой высокой зарплатой");
        return employeeBDRepository.getEmployeeWithHighestSalary();
    }

    @Override
    public void upload(MultipartFile jsonFile) throws IOException {
        LOGGER.info("Был вызван метод для получения списка сотрудников и сохранения их в базе данных");
        String fileName = jsonFile.getName();
        String jsonContent = UtilitiesMethods.readTextFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeDTO employeeDTO = objectMapper.readValue(jsonContent, EmployeeDTO.class);
        List<Employee> employeeList = List.of(employeeDTO.toEmployee());
        LOGGER.debug("Успешно");
        employeeBDRepository.saveAll(employeeList);
    }

}