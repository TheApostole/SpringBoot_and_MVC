package ru.skypro.lessons.springboot.weblibrary.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    private static final Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);

    @Value("${app.env}")
    private String info;

    public String getInfo() {
        logger.info("Был запущен метод вывода информации о профиле");
        return info;
    }

}
