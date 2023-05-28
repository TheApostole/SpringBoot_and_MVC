package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import java.util.List;

public interface EmployeeBDRepository extends CrudRepository<Employee, Integer> {

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.model.projections." +
            "EmployeeFullInfo(e.name, e.salary, p.position_name)" +
            "FROM Employee e JOIN FETCH Position p " +
            "WHERE e.position = p")
    void findAllEmployeeFullInfo();

    @Query(value = "SELECT * FROM employee e where salary = (select MAX(salary) FROM employee e2)",
            nativeQuery = true)
    Employee getEmployeeWithHighestSalary();

    List<Employee> findByName(String name);

    Page<Employee> findAll(Pageable employeeOfConcretePage);
}
