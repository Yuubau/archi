package com.hexa.trademe.domain.domainclass;

import java.math.BigDecimal;
import java.util.List;

public class UpdateConsultant {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Skill> skills;
    private BigDecimal dailyRate;

    public UpdateConsultant(String firstName, String lastName, List<Skill> skills, BigDecimal dailyRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.dailyRate = dailyRate;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
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

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }
}
