package ru.skypro.lessons.springboot.weblibrary.service;
import ru.skypro.lessons.springboot.weblibrary.model.report.Report;
import java.io.IOException;

public interface SomeFileService {
    Long generatesAndSavesJsonFile(String fileName, Report report) throws IOException;

    String getSomeFileById(int id);
}
