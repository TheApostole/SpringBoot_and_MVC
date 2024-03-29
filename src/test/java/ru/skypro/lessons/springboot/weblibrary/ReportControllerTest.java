package ru.skypro.lessons.springboot.weblibrary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.skypro.lessons.springboot.weblibrary.dto.Report;
import ru.skypro.lessons.springboot.weblibrary.model.ReportFile;
import ru.skypro.lessons.springboot.weblibrary.repository.ReportFileRepository;
import java.util.Optional;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
@SpringBootTest
@AutoConfigureMockMvc
public class ReportControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReportFileRepository reportFileRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void generatesAndSavesJsonFileTest() throws Exception {

        Report report = new Report(1,2,3,4,5);

        mockMvc.perform(MockMvcRequestBuilders.post("/report")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(report)))
                .andExpect(status().isForbidden());
    }

    @Test
    void getSomeFileByIDTest() throws Exception {
        int id = 1;
        Optional<ReportFile> employeeOptional = reportFileRepository.findById(id);

        mockMvc.perform(MockMvcRequestBuilders.post("/report/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeOptional)))
                .andExpect(status().isForbidden());
    }
}
