package ru.skypro.lessons.springboot.weblibrary.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import ru.skypro.lessons.springboot.weblibrary.model.report.SomeFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeBDService {
    Employee getEmployeeWithHighestSalary();
    Position getEmployeeByPositionName(String name);
    Employee getEmployeeById(int id);
    List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage);
    void upload(MultipartFile resource) throws IOException;
}
