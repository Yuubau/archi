package com.hexa.trademe.domain.service;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.domainclass.ConsultantSearch;
import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;
import com.hexa.trademe.domain.port.in.ConsultantPort;
import com.hexa.trademe.domain.port.out.DBPort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConsultantService {
    public ConsultantPort port;
    public DBPort dbPort;

    public ConsultantService(ConsultantPort port, DBPort dbPort){
        this.port = port;
        this.dbPort = dbPort;
    }

    public Consultant createConsultant(String firstName, String lastName, List<Skill> skills,
            List<Job> jobs, BigDecimal dailyRate) {
        Consultant toSaveConsultant = port.create(firstName, lastName, skills, jobs, dailyRate);
        return dbPort.saveConsultant(toSaveConsultant);
    }

    public Consultant updateConsultant(Integer id,String firstName, String lastName, List<Skill> skills,
                                       BigDecimal dailyRate) throws Exception {

        Consultant consultant = dbPort.findById(id);
        if (!firstName.isBlank()){
                consultant.setFirstName(firstName);
        }else{
            throw new Exception("prénom manquant");
        }
        if (!lastName.isBlank()){
            consultant.setLastName(lastName);
        }else {
            throw new Exception("nom manquant");
        }
        if (dailyRate != null && dailyRate.compareTo(BigDecimal.ZERO) > 0){
            consultant.setDailyRate(dailyRate);
        }else {
            throw new Exception("TJM manquant");
        }
        if (skills !=null){
            consultant.setSkills(skills);
        }else {
            throw new Exception("skills manquant");
        }

        return dbPort.updateConsultant(consultant);
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
