package com.hexa.trademe.adapter.rest;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;
import com.hexa.trademe.domain.domainclass.UpdateConsultant;
import com.hexa.trademe.domain.port.in.ConsultantPort;

import java.math.BigDecimal;
import java.util.List;

public class ConsultantRestAdapter implements ConsultantPort {

    public Consultant create(String firstName, String lastName, List<Skill> skills,
                             List<Job> jobs, BigDecimal dailyRate) {
        return new Consultant(firstName, lastName, skills, jobs, dailyRate);
    }

    public UpdateConsultant update(String firstName, String lastName, List<Skill> skills, BigDecimal dailyRate) {
        return new UpdateConsultant(firstName,lastName,skills,dailyRate);
    }

    @Override
    public Consultant search() {
        return null;
    }

}