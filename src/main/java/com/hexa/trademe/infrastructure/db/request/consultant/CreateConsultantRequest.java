package com.hexa.trademe.infrastructure.db.request.consultant;

import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;

import java.math.BigDecimal;
import java.util.List;

public final class CreateConsultantRequest {

    public final String firstName;
    public final String lastName;
    public final List<Skill> skills;
    public final List<Job> jobs;
    public final BigDecimal dailyRate;

    public CreateConsultantRequest(String firstName, String lastName, List<Skill> skills, List<Job> jobs, BigDecimal dailyRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.jobs = jobs;
        this.dailyRate = dailyRate;
    }
}
