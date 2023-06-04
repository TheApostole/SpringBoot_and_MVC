package ru.skypro.lessons.springboot.weblibrary.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.service.SomeFileService;

import java.io.IOException;

@RestController
@RequestMapping("/report")
@Getter
@AllArgsConstructor
public class ReportController {

    private final SomeFileService someFileService;

    @PostMapping("/")
    public Long generatesAndSavesJsonFile() throws IOException {
        return someFileService.generatesAndSavesJsonFile();
    }
    @GetMapping("/{id}")
    public String getSomeFileByID(@PathVariable Integer id) {
        return someFileService.getSomeFileById(id);
    }

}
