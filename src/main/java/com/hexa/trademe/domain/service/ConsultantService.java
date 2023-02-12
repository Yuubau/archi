package com.hexa.trademe.domain.service;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.domainclass.Job;
import com.hexa.trademe.domain.domainclass.Skill;
import com.hexa.trademe.domain.domainclass.UpdateConsultant;
import com.hexa.trademe.domain.port.in.ConsultantPort;
import com.hexa.trademe.domain.port.out.DBPort;
import com.hexa.trademe.adapter.db.InMemoryDBAdapter;

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

        //Consultant consultant = dbPort.getByID(id)
        Consultant consultant = new Consultant("firstName","lastName",skills, new ArrayList<Job>(), new BigDecimal(0));
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

        //UpdateConsultant toUpdateConsultant = port.update(firstName, lastName, skills, dailyRate);

        return dbPort.saveConsultant(consultant);
    }
}
