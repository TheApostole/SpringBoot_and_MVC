package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import java.util.List;

public interface EmployeeBDRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "SELECT new ru.skypro.lessons.springboot.weblibrary.model.projections." +
            "EmployeeFullInfo(e.name, e.salary, p.position_name,e.department)" +
            "FROM Employee e JOIN FETCH Position p " +
            "WHERE e.position = p")
    void findAllEmployeeFullInfo();

    @Query(value = "SELECT * FROM employee e where salary = (select MAX(salary) FROM employee e2)",
            nativeQuery = true)
    Employee getEmployeeWithHighestSalary();

    List<Employee> findByName(String name);

    Page<Employee> findAll(Pageable employeeOfConcretePage);

    @Query(value = "SELECT department FROM employee GROUP BY department",
            nativeQuery = true)
    Integer sortDepartment();

    @Query(value = "SELECT AVG(salary) AS average_salary FROM employee GROUP BY department",
            nativeQuery = true)
    Integer averageSalary();

    @Query(value = "SELECT min(salary) AS min_salary FROM employee GROUP BY department",
            nativeQuery = true)
    Integer minSalary();

    @Query(value = "SELECT max(salary) AS max_salary FROM employee GROUP BY department",
            nativeQuery = true)
    Integer maxSalary();

    @Query(value = "SELECT COUNT AS count_employee FROM employee GROUP BY department",
            nativeQuery = true)
    Integer countEmployeeInDepartment();

}
