package com.hexa.trademe.infrastructure.db;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.domainclass.ConsultantSearch;
import com.hexa.trademe.domain.port.out.DBPort;
import com.hexa.trademe.infrastructure.db.model.ConsultantModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemory implements DBPort {
    public HashMap<Integer, ConsultantModel> consultants;
    public Integer consultantsLastId;

    private static InMemory instance;

    public static InMemory getInstance() {
        if (instance == null) {
            instance = new InMemory();
            instance.consultants = new HashMap<>();
            instance.consultantsLastId = 1;
        }
        return instance;
    }

    @Override
    public Consultant saveConsultant(Consultant consultant) {
        consultant.setId(consultantsLastId++);
        this.consultants.put(consultant.getId(), new ConsultantModel(consultant));
        return consultant;
    }

    @Override
    public List<Consultant> getAllConsultants() {
        List<Consultant> res = new ArrayList<>();
        for(Integer id:this.consultants.keySet()){
            Consultant c = this.consultants.get(id).asConsultant();
            c.setId(id);
            res.add(c);
        }
        return res;
    }

    @Override
    public Consultant updateConsultant(Consultant consultant) {
        for(Integer cId:this.consultants.keySet()){
            if(cId == consultant.getId()) {
                this.consultants.replace(cId,new ConsultantModel(consultant));
            }
        }
        return consultant;
    }

    @Override
    public Consultant findById(Integer id) {
        for(Integer cId:this.consultants.keySet()){
            if(cId == id) {
                Consultant c = this.consultants.get(id).asConsultant();
                c.setId(cId);
                return c;
            }
        }
        return null;
    }

}
