package com.example.hr.Repo;

import com.example.hr.Domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
    Optional<Candidate> findByName(String name);

}
