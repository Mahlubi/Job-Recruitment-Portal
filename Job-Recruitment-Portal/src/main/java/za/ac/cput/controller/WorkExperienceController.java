package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.WorkExperience;
import za.ac.cput.service.WorkExperienceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workexperience")
public class WorkExperienceController {
    @Autowired
    private WorkExperienceService workExperienceService;

    @GetMapping
    public List<WorkExperience> getAllWorkExperiences() {
        return workExperienceService.getAllWorkExperiences();
    }

    @GetMapping("/{id}")
    public Optional<WorkExperience> getWorkExperienceById(@PathVariable Long id) {
        return workExperienceService.getWorkExperienceById(id);
    }

    @PostMapping
    public WorkExperience createWorkExperience(@RequestBody WorkExperience workExperience) {
        return workExperienceService.saveWorkExperience(workExperience);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkExperience(@PathVariable Long id) {
        workExperienceService.deleteWorkExperience(id);
    }
}
