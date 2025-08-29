package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.List;

@Entity
@Table(name = "job_seekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobSeeker extends User {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String profileSummary;

    @OneToOne(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
    private Resume resume;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
    private List<Application> applications;
}