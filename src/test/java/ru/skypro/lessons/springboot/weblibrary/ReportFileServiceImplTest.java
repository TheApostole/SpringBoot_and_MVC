package ru.skypro.lessons.springboot.weblibrary;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import ru.skypro.lessons.springboot.weblibrary.model.ReportFile;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeBDRepository;
import ru.skypro.lessons.springboot.weblibrary.repository.ReportFileRepository;
import ru.skypro.lessons.springboot.weblibrary.service.ReportFileServiceImpl;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportFileServiceImplTest {

    @Mock
    private EmployeeBDRepository employeeBDRepository;

    @Mock
    private ReportFileRepository reportFileRepository;
    @InjectMocks
    private ReportFileServiceImpl reportFileService;

    @SneakyThrows
    @Test
    public void generatesAndSavesJsonFileTestOnTheReturnedResultAndToTheMethodCall() throws IOException {
        Integer expected = 0;
        ReportFile reportFile = new ReportFile();
        lenient().when(employeeBDRepository.sortDepartment())
                .thenReturn(expected);
        assertNull(reportFileService.generatesAndSavesJsonFile());

        lenient().when(employeeBDRepository.countEmployeeInDepartment())
                .thenReturn(expected);
        assertNull(reportFileService.generatesAndSavesJsonFile());

        lenient().when(employeeBDRepository.maxSalary())
                .thenReturn(expected);
        assertNull(reportFileService.generatesAndSavesJsonFile());

        lenient().when(employeeBDRepository.minSalary())
                .thenReturn(expected);
        assertNull(reportFileService.generatesAndSavesJsonFile());

        lenient().when(employeeBDRepository.averageSalary())
                .thenReturn(expected);
        assertNull(reportFileService.generatesAndSavesJsonFile());

        verify(reportFileRepository, never())
                .save(reportFile);
    }

    @Test
    public void getSomeFileByIdNegativeTestAndTestCallMethod () {
        verify(reportFileRepository, never())
                .findById(anyInt());

        lenient().doThrow(IncorrectResultSizeDataAccessException.class)
                .when(reportFileRepository).findById(anyInt());
        assertThrows(IncorrectResultSizeDataAccessException.class, ()-> reportFileService.getSomeFileById(anyInt()));
    }
}
