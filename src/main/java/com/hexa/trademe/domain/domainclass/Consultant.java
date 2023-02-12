package com.hexa.trademe.domain.domainclass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consultant {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Skill> skills;
    private List<Job> jobs;
    private BigDecimal dailyRate;

    public Consultant(String firstName, String lastName, List<Skill> skills,
                      List<Job> jobs, BigDecimal dailyRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.jobs = jobs;
        this.dailyRate = dailyRate;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                ", jobs=" + jobs +
                ", dailyRate=" + dailyRate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }
}
