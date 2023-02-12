package com.hexa.trademe.infrastructure.db.model;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;

import java.math.BigDecimal;
import java.util.List;

public class ConsultantModel {

    private final String firstName;
    private final String lastName;
    private final List<Skill> skills;
    private final List<Job> jobs;
    private final BigDecimal dailyRate;

    public ConsultantModel(Consultant consultant) {
        this.firstName = consultant.getFirstName();
        this.lastName = consultant.getLastName();
        this.skills = consultant.getSkills();
        this.jobs = consultant.getJobs();
        this.dailyRate = consultant.getDailyRate();
    }
    

    public Consultant asConsultant() {
        Consultant c = new Consultant();
        c.setFirstName(this.firstName);
        c.setLastName(this.lastName);
        c.setJobs(this.jobs);
        c.setSkills(this.skills);
        c.setDailyRate(this.dailyRate);
        return c;
    }


}
