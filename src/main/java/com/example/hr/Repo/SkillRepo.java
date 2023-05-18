package com.example.hr.Repo;

import com.example.hr.Domain.Candidate;
import com.example.hr.Domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepo extends JpaRepository<Skill, Integer> {
}