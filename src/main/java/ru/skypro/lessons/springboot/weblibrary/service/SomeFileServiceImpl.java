package ru.skypro.lessons.springboot.weblibrary.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.model.report.Report;
import ru.skypro.lessons.springboot.weblibrary.model.report.SomeFile;
import ru.skypro.lessons.springboot.weblibrary.repository.SomeFileRepository;
import ru.skypro.lessons.springboot.weblibrary.util.UtilitiesMethods;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SomeFileServiceImpl implements SomeFileService {

    private final SomeFileRepository someFileRepository;
    @Override
    public Long generatesAndSavesJsonFile(String fileName, Report report) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(report);
        UtilitiesMethods.writeTextToFile(json, fileName);
        SomeFile someFile = new SomeFile();
        someFile.setFileName(fileName);
        someFileRepository.save(someFile);
        return someFile.getId();
    }
    @Override
    public String getSomeFileById(int id) {
        Optional<SomeFile> employeeOptional = someFileRepository.findById(id);
        employeeOptional.orElseThrow(() -> new IncorrectResultSizeDataAccessException(id));
        SomeFile someFile = employeeOptional.get();
        return someFile.getFileName();
    }
}
