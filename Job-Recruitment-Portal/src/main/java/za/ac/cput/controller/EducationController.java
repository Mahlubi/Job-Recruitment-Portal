package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Education;
import za.ac.cput.service.EducationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<Education> getAllEducations() {
        return educationService.getAllEducations();
    }

    @GetMapping("/{id}")
    public Optional<Education> getEducationById(@PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationService.saveEducation(education);
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
