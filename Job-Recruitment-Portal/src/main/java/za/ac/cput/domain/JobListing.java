package za.ac.cput.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "job_listings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String title;
    private String description;
    private String location;
    private String salary;
    private String employmentType;
    private LocalDateTime postedDate;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    @JsonBackReference
    private Employer employer;

    @OneToMany(mappedBy = "jobListing", cascade = CascadeType.ALL)
    private List<Application> applications;

    @ManyToMany
    @JoinTable(
            name = "joblisting_skills",
            joinColumns = @JoinColumn(name = "joblisting_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;
}
