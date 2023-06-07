package ru.skypro.lessons.springboot.weblibrary.service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import java.io.IOException;
import java.util.List;
public interface EmployeeBDService {

    Employee getEmployeeWithHighestSalary();
    Position getEmployeeByPositionName(String name);
    Employee getEmployeeById(int id);
    List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage);
    void upload(MultipartFile resource) throws IOException;

}
