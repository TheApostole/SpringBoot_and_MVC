package ru.skypro.lessons.springboot.weblibrary.service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;

import java.io.IOException;
import java.util.List;
public interface EmployeeBDService {

    Employee getEmployeeWithHighestSalary();
    List<Employee> getEmployeeByPositionName(String name);
    EmployeeDTO getEmployeeById(int id);
    List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage);
    void upload(Class<MultipartFile> resource) throws IOException;

}
