package ru.skypro.lessons.springboot.weblibrary.repository;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.weblibrary.model.report.ReportFile;
public interface ReportFileRepository extends CrudRepository<ReportFile, Integer> {

}
