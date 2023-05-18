package com.example.hr.Controller;

import com.example.hr.Domain.Candidate;
import com.example.hr.Domain.Skill;
import com.example.hr.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
1. dodaj kandidata
2. dodaj skil kandidatu
3. obrisi skil kandidatu
4. obrisi kandidata
5. pretrazi kandidata po imenu
*/

@RestController
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/candidate")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        return candidateService.addCandidate(candidate);
    }

    @PostMapping("/candidate/{id}")
    public ResponseEntity<Skill> addSkillToCandidate(@RequestBody Skill skill, int id) {
        return candidateService.addSkillToCandidate(skill, id);
    }

    @DeleteMapping("/candidate/skill/{id}")
    public ResponseEntity<Skill> removeSkillFromCandidate(@RequestBody Skill skill, int id) {
        return candidateService.removeSkillFromCandidate(skill, id);
    }

    @DeleteMapping("/candidate/{id}")
    public ResponseEntity<Candidate> removeCandidate(@PathVariable int id) {
        return candidateService.removeCandidate(id);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Candidate> findCandidateByName(@PathVariable String name) {
        return candidateService.findCandidateByName(name);
    }
}
