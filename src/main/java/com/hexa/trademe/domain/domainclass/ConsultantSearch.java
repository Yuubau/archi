package com.hexa.trademe.domain.domainclass;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ConsultantSearch {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Date> dates;
    private List<Skill> skills;
    private BigDecimal maxDailyRate;


    public ConsultantSearch(Integer id, String firstName, String lastName, List<Skill> skills,
                      List<Date> dates, BigDecimal maxDailyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dates = dates;
        this.skills = skills;
        this.maxDailyRate = maxDailyRate;
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

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public BigDecimal getMaxDailyRate() {
        return maxDailyRate;
    }

    public void setMaxDailyRate(BigDecimal maxDailyRate) {
        this.maxDailyRate = maxDailyRate;
    }
}
