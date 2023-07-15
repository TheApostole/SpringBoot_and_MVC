package ru.skypro.lessons.springboot.weblibrary.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class EmployeeNoBD {

    private Integer id;
    private String name;
    private Integer salary;
    private PositionNoBD position;

    public EmployeeNoBD() {

    }
}
