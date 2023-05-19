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
import java.util.Set;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    @Autowired
    private SkillRepo skillRepo;

    public ResponseEntity<Candidate> findCandidateByName(String name) {
        Optional<Candidate> optionalCandidate = candidateRepo.findByName(name);
        if(optionalCandidate.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalCandidate.get(), HttpStatus.FOUND);
    }

    public ResponseEntity<Candidate> addCandidate(Candidate candidate) {
        candidateRepo.save(candidate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Skill> addSkillToCandidate(int candidateID, int skillID) {
        System.out.println(candidateID + " " + skillID);
        Optional<Candidate> optionalCandidate = candidateRepo.findById(candidateID);
        if(optionalCandidate.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Skill> optionalSkill = skillRepo.findById(skillID);
        if(optionalSkill.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Candidate oldCandidate = optionalCandidate.get();
        if(oldCandidate.getSkills().contains(optionalSkill.get())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        oldCandidate.getSkills().add(optionalSkill.get());
        candidateRepo.save(oldCandidate);

//        Skill oldSkill = optionalSkill.get();
//        oldSkill.getCandidates().add(oldCandidate);
//        skillRepo.save(oldSkill);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<Skill> removeSkillFromCandidate(int candidateID, int skillID) {
        Optional<Candidate> optionalCandidate = candidateRepo.findById(candidateID);
        if(optionalCandidate.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Skill> optionalSkill = skillRepo.findById(skillID);
        if(optionalSkill.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Candidate oldCandidate = optionalCandidate.get();
        if(!oldCandidate.getSkills().contains(optionalSkill.get())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        oldCandidate.getSkills().remove(optionalSkill.get());
        candidateRepo.save(oldCandidate);

        Skill oldSkill = optionalSkill.get();
        oldSkill.getCandidates().remove(oldCandidate);
        skillRepo.save(oldSkill);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Candidate> removeCandidate(int id) {
        Optional<Candidate> optionalCandidate = candidateRepo.findById(id);
        if(optionalCandidate.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        candidateRepo.delete(optionalCandidate.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
