package ru.skypro.lessons.springboot.weblibrary.dto;
import lombok.Getter;
import lombok.Setter;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;

import java.io.Serializable;

@Getter
@Setter

public class EmployeeDTO implements Serializable {

    private Integer id;
    private String name;
    private Integer salary;
    private Position position;
    private Integer department;

    public static EmployeeDTO toDTO(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setDepartment(employee.getDepartment());
        return employeeDTO;

    }

    public Employee toEmployee() {

        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        employee.setPosition(this.getPosition());
        employee.setDepartment(this.getDepartment());
        return employee;

    }

    public EmployeeDTO() {
    }
}
