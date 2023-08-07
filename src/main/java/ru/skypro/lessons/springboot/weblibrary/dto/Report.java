package ru.skypro.lessons.springboot.weblibrary.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Report {

    private Integer department;
    private Integer numberOfEmployees;
    private Integer maximumSalary;
    private Integer minimumWage;
    private Integer averageSalary;

    public Report(Integer department, Integer numberOfEmployees, Integer maximumSalary, Integer minimumWage, Integer averageSalary) {
        this.department = department;
        this.numberOfEmployees = numberOfEmployees;
        this.maximumSalary = maximumSalary;
        this.minimumWage = minimumWage;
        this.averageSalary = averageSalary;
    }
}
