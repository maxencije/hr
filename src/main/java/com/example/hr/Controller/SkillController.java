package com.example.hr.Controller;

import com.example.hr.Domain.Candidate;
import com.example.hr.Domain.Skill;
import com.example.hr.Service.CandidateService;
import com.example.hr.Service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/*
1. dodavanje skill-a
2. pretraga kandidata po skill-u
* */

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/skill")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) throws Exception {
        return skillService.addSkill(skill);
    }

    @GetMapping("/skill/search/{id}")
    public ResponseEntity<Skill> findSkillById(@PathVariable int id) {
        return skillService.findSkillById(id);
    }

    @GetMapping("/skill/{id}")
    public ResponseEntity<Set<Candidate>> findCandidatesBySkill(@PathVariable("id") int id) {
        return skillService.findCandidatesBySkill(id);
    }
}