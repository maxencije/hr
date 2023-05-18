package com.example.hr.Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue
    private int skill_id;

    private String name;

    @ManyToMany(mappedBy = "skills")
    private List<Candidate> candidates = new ArrayList<>();

    public Skill() {
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public String getName() {
        return name;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }
}