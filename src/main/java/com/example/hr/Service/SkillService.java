package com.example.hr.Service;

import com.example.hr.Domain.Candidate;
import com.example.hr.Domain.Skill;
import com.example.hr.Repo.CandidateRepo;
import com.example.hr.Repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepo skillRepo;

    public ResponseEntity<Skill> addSkill(Skill skill) {
        Optional<Skill> optionalSkill = skillRepo.findById(skill.getSkill_id());
        if(optionalSkill.isPresent()) {
            return new ResponseEntity<>(optionalSkill.get(), HttpStatus.CONFLICT);
        }
        Skill saved = skillRepo.save(skill);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Candidate>> findCandidatesBySkill(int id) {
        Optional<Skill> optionalSkill = skillRepo.findById(id);
        if(optionalSkill.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalSkill.get().getCandidates(), HttpStatus.FOUND);
    }
}
