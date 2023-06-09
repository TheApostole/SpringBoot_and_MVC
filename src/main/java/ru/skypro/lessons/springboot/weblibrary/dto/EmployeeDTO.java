package ru.skypro.lessons.springboot.weblibrary.dto;
import lombok.Getter;
import lombok.Setter;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import java.io.Serializable;

@Getter
@Setter

public class EmployeeDTO implements Serializable {

    private Integer id;
    private String name;
    private Integer salary;
    private String position_name;

    public static EmployeeDTO fromEmployee(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;

    }

    public Employee toEmployee() {

        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        return employee;

    }
}
