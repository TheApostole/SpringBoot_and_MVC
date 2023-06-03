package ru.skypro.lessons.springboot.weblibrary.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import ru.skypro.lessons.springboot.weblibrary.model.report.Report;
import ru.skypro.lessons.springboot.weblibrary.model.report.SomeFile;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeBDService;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.SomeFileService;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Getter
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeBDService employeeBDService;

    private final SomeFileService someFileService;

    @GetMapping("/salary/sum")
    public Integer getSumSalaryEmployees() {
        return employeeService.getSumSalary();
    }
    @GetMapping("/salary/min")
    public Employee getMinSalary() {
        return employeeService.getMinSalary();
    }
    @GetMapping("/salary/max")
    public Employee getMaxSalary() {
        return employeeService.getMaxSalary();
    }
    @GetMapping("/high-salary")
    public List<Employee> getHighSalary() {
        return employeeService.getHighSalary();
    }
    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    public List<Employee> editEmployee(@PathVariable Integer id, String name, Integer salary) {
        return employeeService.editEmployee(id, name, salary);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable Integer id) {
        return employeeService.getEmployeeByID(id);
    }
    @DeleteMapping("/delete{id}")
    public void deleteEmployeeByID(@PathVariable Integer id) {
        employeeService.deleteEmployeeByID(id);
    }
    @GetMapping("/salaryHigherThan")
    public List<Employee> getEmployeesWhoseSalaryIsHigherThanTheParameter(@RequestParam("salary") Integer salary) {
        return employeeService.getEmployeesWhoseSalaryIsHigherThanTheParameter(salary);
    }
    @GetMapping("/withHighestSalary")
    public Employee getEmployeeWithHighestSalary() {
        return employeeBDService.getEmployeeWithHighestSalary();
    }
    @GetMapping("/")
    public Position getEmployeeByPositionName(@RequestParam String name) {
        return employeeBDService.getEmployeeByPositionName(name);
    }
    @GetMapping("/{id}/fullInfo")
    public Employee getEmployeesById(@PathVariable int id) {
        return employeeBDService.getEmployeeById(id);
    }
    @GetMapping("/page")
    public List<Employee> getEmployeeWithPaging(@RequestParam int pageIndex, int unitPerPage) {
        return employeeBDService.getEmployeeWithPaging(pageIndex, unitPerPage);
    }
    @PostMapping(value = "/upload" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void create(@RequestParam("file") MultipartFile file) throws IOException {
       employeeBDService.upload(file);
    }
    @RequestMapping("/report")

    @PostMapping("/")
    public Long generatesAndSavesJsonFile(@RequestBody String fileName, Report report) throws IOException {
        return someFileService.generatesAndSavesJsonFile(fileName, report);
    }
    @GetMapping("/{id}")
    public String getSomeFileByID(@PathVariable Integer id) {
        return someFileService.getSomeFileById(id);
    }
}