package com.hexa.trademe.infrastructure.db;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.port.out.DBPort;

import java.util.ArrayList;
import java.util.List;

public class InMemory implements DBPort {
    public List<Consultant> consultants;
    public Integer consultantsLastId;

    private static InMemory instance;

    public static InMemory getInstance() {
        if (instance == null) {
            instance = new InMemory();
            instance.consultants = new ArrayList<>();
            instance.consultantsLastId = 0;
        }
        return instance;
    }

    @Override
    public Consultant saveConsultant(Consultant consultant) {
        consultant.setId(consultantsLastId++);
        this.consultants.add(consultant);
        return consultant;
    }
}
