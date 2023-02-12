package com.hexa.trademe.domain.service;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.domainclass.ConsultantSearch;
import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;
import com.hexa.trademe.domain.port.in.ConsultantPort;
import com.hexa.trademe.domain.port.out.DBPort;
import com.hexa.trademe.adapter.db.InMemoryDBAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public List<Consultant> searchConsultant(ConsultantSearch search) {
        if(search.getId() != null) {
            List<Consultant> cList = new ArrayList<>();
            Consultant c = dbPort.findById(search.getId());
            if(c != null) {
                cList.add(c);
            }
            return cList;
        }
        List<Consultant> consultants = dbPort.getAllConsultants();
        List<Consultant> res = new ArrayList<>();
        for(Consultant c:consultants) {
            if(search.getFirstName() != null && !c.getFirstName().equals(search.getFirstName())) {
                continue;
            }
            if(search.getLastName() != null && !c.getLastName().equals(search.getLastName())) {
                continue;
            }
            if(search.getMaxDailyRate() != null && c.getDailyRate().compareTo(search.getMaxDailyRate()) == 1) {
                continue;
            }
            if(search.getSkills() != null && !search.getSkills().isEmpty()) {
                boolean flag = false;
                for(Skill s:search.getSkills()) {
                    if(!c.getSkills().contains(s)) {
                        flag = true;
                        break;
                    }
                }
                if(flag) continue;
            }

            // TODO date search

            res.add(c);
        }
        return res;
    }
}
