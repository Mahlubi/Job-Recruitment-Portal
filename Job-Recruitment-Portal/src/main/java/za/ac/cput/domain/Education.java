package za.ac.cput.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDate;

@Entity
@Table(name = "education")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;
    private String degree;
    private String institution;
    private String fieldOfStudy;
    private LocalDate graduationDate;
    private Double gpa;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}