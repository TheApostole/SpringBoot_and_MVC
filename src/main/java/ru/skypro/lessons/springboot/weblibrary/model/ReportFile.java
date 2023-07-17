package ru.skypro.lessons.springboot.weblibrary.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table (name = "report")

public class ReportFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(name = "file_name", columnDefinition = "text")
    private String fileName;

    public ReportFile() {
    }

}
