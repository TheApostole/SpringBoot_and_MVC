package ru.skypro.lessons.springboot.weblibrary;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import java.util.List;

@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testForAdding_Editing_And_DeletingEmployee() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 0);
        jsonObject.put("name", "test_name");
        jsonObject.put("salary", 10000);
        jsonObject.put("position", "test_name");
        jsonObject.put("department", 1);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString()))
                .andExpect(status().isBadRequest());

        mockMvc.perform(MockMvcRequestBuilders.put("/admin/employees/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject.toString()))
                .andExpect(status().isNotFound());

        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/employees/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString()))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void getSumSalaryEmployeesTest() throws Exception {

         JSONObject jsonObject = new JSONObject();

         mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/salary/sum")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content(jsonObject.toString()))
                 .andExpect(status().isOk());
    }

    @Test
    void getMinSalaryTest() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "0");
        jsonObject.put("name", "test_name");
        jsonObject.put("salary", 10000);
        jsonObject.put("department", 1);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/salary/min")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString()))
                .andExpect(status().isOk());
    }

    @Test
    void getMaxSalary () throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "0");
        jsonObject.put("name", "test_name");
        jsonObject.put("salary", 10000);
        jsonObject.put("department", 1);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/salary/max")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString()))
                .andExpect(status().isOk());
    }

    @Test
    void getEmployeesWhoseSalaryIsHigherThanTheParameterTest() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "0");
        jsonObject.put("name", "test_name");
        jsonObject.put("salary", 10000);
        jsonObject.put("department", 1);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/high-salary")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString()))
                .andExpect(status().isOk());
    }

    @Test
    void getEmployeeWithHighestSalaryTestAndTestAddEmployee() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/employees/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDTO)))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/withHighestSalary")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeDTO.toString()))
                .andExpect(status().isOk());
    }

    @Test
    void getEmployeesByIdTest() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/fullInfo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDTO)))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void testMethodCreate() throws Exception {

        MockMultipartFile multipartFile = new MockMultipartFile(
                "fileEmployees",
                "employees.json",
                MediaType.APPLICATION_JSON_VALUE,
                EmployeeControllerTest.class.getResourceAsStream("/employees.json"));
        mockMvc.perform(MockMvcRequestBuilders.multipart("/admin/employees/upload")
                        .file(multipartFile)
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andExpect(status().isBadRequest());
    }
    @Test
    void getEmployeeByIDTestNoBD() throws Exception{

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "0");
        jsonObject.put("name", "test_name");
        jsonObject.put("salary", 10000);
        jsonObject.put("department", 1);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/get")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString()))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void getEmployeeByPositionNameTest() throws Exception{

        List<Employee> employeeList = List.of(
                new Employee(1, "Санёк", 94_000, new Position( "Рабочий")),
                new Employee(1, "Санёк", 94_000, new Position("Рабочий"))
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/pos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeList)))
                .andExpect(status().isBadRequest());
    }
    @Test
    void getEmployeeWithPagingTest() throws Exception{

        List<Employee> employeeList = List.of(
                new Employee(1, "Санёк", 94_000, new Position("Рабочий")),
                new Employee(1, "Санёк", 94_000, new Position("Рабочий"))
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/employees/page")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeList)))
                .andExpect(status().isBadRequest());
    }
}
