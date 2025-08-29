package za.ac.cput.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "employers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Employer extends User {

    private String companyName;
    private String industry;
    private String website;
    private String location;
    private String contactPerson;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<JobListing> jobListings;

    public static Employer buildFromDto(String email, String password, String role, String companyName, String industry, String website, String location, String contactPerson) {
        return Employer.builder()
                .companyName(companyName)
                .industry(industry)
                .website(website)
                .location(location)
                .contactPerson(contactPerson)
                .build();
    }
}