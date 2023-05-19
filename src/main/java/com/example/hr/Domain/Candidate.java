package com.example.hr.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue
    private int candidate_id;

    //@Column(unique = true)
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
    @JsonIgnore
    private Set<Skill> skills = new HashSet<>();

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

    public void setSkills(Set<Skill> skills) {
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

    public Set<Skill> getSkills() {
        return skills;
    }
}
