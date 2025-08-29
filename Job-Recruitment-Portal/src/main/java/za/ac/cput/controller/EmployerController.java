package za.ac.cput.controller;
import za.ac.cput.domain.Employer;
import za.ac.cput.service.EmployerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    @GetMapping("/{id}")
    public Optional<Employer> getEmployerById(@PathVariable Long id) {
        return employerService.getEmployerById(id);
    }

    @PostMapping
    public Employer createEmployer(@RequestBody Employer employer) {
        return employerService.saveEmployer(employer);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
    }

    // DTO for employee registration
    public static class EmployerRegistrationDTO {
        public String email;
        public String password;
        public String companyName;
        public String industry;
        public String website;
        public String location;
        public String contactPerson;
    }

    @PostMapping("/register")
    public Employer registerEmployer(@RequestBody EmployerRegistrationDTO dto) {
        Employer employer = Employer.buildFromDto(
                dto.email,
                dto.password,
                "EMPLOYER",
                dto.companyName,
                dto.industry,
                dto.website,
                dto.location,
                dto.contactPerson
        );
        employer.setEmail(dto.email);
        employer.setPassword(dto.password);
        employer.setRole("EMPLOYER");
        return employerService.saveEmployer(employer);
    }
}
