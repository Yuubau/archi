package com.hexa.trademe.domain.port.in;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;

import java.math.BigDecimal;
import java.util.List;

public interface ConsultantPort {


    public Consultant create(String firstName, String lastName, List<Skill> skills,
                                             List<Job> jobs, BigDecimal dailyRate);
}
