package ru.skypro.lessons.springboot.weblibrary.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.Report;
import ru.skypro.lessons.springboot.weblibrary.model.ReportFile;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeBDRepository;
import ru.skypro.lessons.springboot.weblibrary.repository.ReportFileRepository;
import ru.skypro.lessons.springboot.weblibrary.util.UtilitiesMethods;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@Service

public class ReportFileServiceImpl implements ReportFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportFileServiceImpl.class);
    private final EmployeeBDRepository employeeBDRepository;
    private final ReportFileRepository reportFileRepository;

    @Override
    public Long generatesAndSavesJsonFile() throws IOException {
        LOGGER.info("Был вызван метод генерации и сохранения Json - файла ");
        String fileName = "report.json";
        File file = new File(fileName);
        file.createNewFile();
        Report report = new Report(employeeBDRepository.sortDepartment(),employeeBDRepository.countEmployeeInDepartment(),
                employeeBDRepository.maxSalary(),employeeBDRepository.minSalary(), employeeBDRepository.averageSalary());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(report);
        UtilitiesMethods.writeTextToFile(json, fileName);
        ReportFile reportFile = new ReportFile();
        reportFile.setFileName(fileName);
        reportFileRepository.save(reportFile);
        LOGGER.debug("Успешно");
        return reportFile.getId();
    }

    @Override
    public String getSomeFileById(int id) {
        LOGGER.info("Был вызван метод для нахождения файла по id = {}", id);
        Optional<ReportFile> employeeOptional = reportFileRepository.findById(id);
        employeeOptional.orElseThrow(() -> new IncorrectResultSizeDataAccessException(id));
        ReportFile someFile = employeeOptional.get();
        LOGGER.debug("Успешно");
        return someFile.getFileName();
    }
}
