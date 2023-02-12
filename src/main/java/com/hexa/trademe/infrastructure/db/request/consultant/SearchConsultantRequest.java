package com.hexa.trademe.infrastructure.db.request.consultant;

import com.hexa.trademe.domain.domainclass.ConsultantSearch;
import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public final class SearchConsultantRequest {
    public final Integer id;
    public final String firstName;
    public final String lastName;
    public final List<Skill> skills;
    public final List<Date> dates;
    public final BigDecimal maxDailyRate;

    public SearchConsultantRequest(Integer id, String firstName, String lastName, List<Skill> skills, List<Date> dates, BigDecimal maxDailyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.dates = dates;
        this.maxDailyRate = maxDailyRate;
    }

    public ConsultantSearch asSearch() {
        return new ConsultantSearch(id, firstName, lastName, skills, dates, maxDailyRate);
    }
}
