package com.hexa.trademe.infrastructure.db.request.consultant;

import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;

import java.math.BigDecimal;
import java.util.List;

public final class UpdateConsultantRequest {

    public final Integer id;
    public final String firstName;
    public final String lastName;
    public final List<Skill> skills;
    public final BigDecimal dailyRate;

    public UpdateConsultantRequest(Integer id, String firstName, String lastName, List<Skill> skills, BigDecimal dailyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.dailyRate = dailyRate;
    }
}
