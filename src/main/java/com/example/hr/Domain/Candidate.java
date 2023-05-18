package com.example.hr.Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue
    private int candidate_id;

    private String name;
    private Date birthday;
    private String contact;
    private String email;
    @ManyToMany(cascade = { CascadeType.ALL} )
    @JoinTable(
            name = "candidate_skill",
            joinColumns = { @JoinColumn(name = "candidate_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
    private List<Skill> skills = new ArrayList<>();

    public Candidate() {
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getCandidate_id() {
        return candidate_id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
