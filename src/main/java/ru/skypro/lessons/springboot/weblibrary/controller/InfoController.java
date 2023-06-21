package ru.skypro.lessons.springboot.weblibrary.controller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrary.service.InfoService;

@RestController
@RequestMapping("/")
@Getter
@AllArgsConstructor

public class InfoController {

    private final InfoService infoService;

    @GetMapping("/")
    public String info(){
        return infoService.getInfo();
    }

}
