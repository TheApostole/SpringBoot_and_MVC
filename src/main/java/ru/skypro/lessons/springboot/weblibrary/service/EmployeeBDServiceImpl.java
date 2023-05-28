package ru.skypro.lessons.springboot.weblibrary.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeBDRepository;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeBDServiceImpl implements EmployeeBDService {
    private final EmployeeBDRepository employeeBDRepository;

   @Override
    public Position getEmployeeByPositionName(String name) {
      if (name.equals(" ")){
           employeeBDRepository.findAllEmployeeFullInfo();
      }
       return employeeBDRepository.findByName(name).get(0).getPosition();
   }

   @Override
   public Employee getEmployeeById(int id) {
       Optional<Employee> employeeOptional = employeeBDRepository.findById(id);
       return employeeOptional.orElseThrow(() -> new IncorrectResultSizeDataAccessException(id));
   }

   @Override
   public List<Employee> getEmployeeWithPaging(int pageIndex, int unitPerPage) {
      Pageable employeeOfConcretePage = PageRequest.of(pageIndex, unitPerPage);
      Page <Employee> page = employeeBDRepository.findAll(employeeOfConcretePage);
      return page.stream().toList();
   }
    public Employee getEmployeeWithHighestSalary() {
       return employeeBDRepository.getEmployeeWithHighestSalary();
    }
}
