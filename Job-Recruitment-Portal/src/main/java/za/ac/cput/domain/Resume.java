package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "resumes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    @ManyToMany
    @JoinTable(
            name = "resume_skills",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<WorkExperience> experience;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Education> education;

    @ElementCollection
    private List<String> certifications;

    private LocalDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
