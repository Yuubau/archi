package com.hexa.trademe.domain.service;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;
import com.hexa.trademe.domain.port.in.ConsultantPort;
import com.hexa.trademe.domain.port.out.DBPort;
import com.hexa.trademe.adapter.db.InMemoryDBAdapter;

import java.math.BigDecimal;
import java.util.List;

public class ConsultantService {
    public ConsultantPort port;
    public DBPort dbPort;

    public ConsultantService(ConsultantPort port, InMemoryDBAdapter dbPort){
        this.port = port;
        this.dbPort = dbPort;
    }

    public Consultant createConsultant(String firstName, String lastName, List<Skill> skills,
            List<Job> jobs, BigDecimal dailyRate) {
        Consultant toSaveConsultant = port.create(firstName, lastName, skills, jobs, dailyRate);
        return dbPort.saveConsultant(toSaveConsultant);
    }
}
