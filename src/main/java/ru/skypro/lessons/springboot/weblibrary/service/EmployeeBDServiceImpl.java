package ru.skypro.lessons.springboot.weblibrary.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import ru.skypro.lessons.springboot.weblibrary.model.report.SomeFile;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeBDRepository;
import ru.skypro.lessons.springboot.weblibrary.util.UtilitiesMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeBDServiceImpl implements EmployeeBDService {
    private final EmployeeBDRepository employeeBDRepository;

    @Override
    public Position getEmployeeByPositionName(String name) {
        if (name.equals(" ")) {
            employeeBDRepository.findAllEmployeeFullInfo();
        }
        return employeeBDRepository.findByName(name).get(0).getPosition();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employeeOptional = employeeBDRepository.findById(id);
        return employeeOptional.orElseThrow(() -> new IncorrectResultSizeDataAccessException(id));
    }

    @Override
    public List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage) {
        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, unitPerPage);
        Page<Employee> page = employeeBDRepository.findAll(employeeOfConcretePage);
        return page.stream().toList();
    }

    public Employee getEmployeeWithHighestSalary() {
        return employeeBDRepository.getEmployeeWithHighestSalary();
    }

    public void upload(MultipartFile jsonFile) throws IOException {
        String fileName = jsonFile.getName();
        String jsonContent = UtilitiesMethods.readTextFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeDTO employeeDTO = objectMapper.readValue(jsonContent, EmployeeDTO.class);
        List<Employee> employeeList = List.of(employeeDTO.toEmployee());
        employeeBDRepository.saveAll(employeeList);
    }
}