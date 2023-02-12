package com.hexa.trademe.adapter.db;

import com.hexa.trademe.domain.port.out.DBPort;
import com.hexa.trademe.infrastructure.db.InMemory;
import com.hexa.trademe.domain.domainclass.Consultant;

import java.util.List;

public class InMemoryDBAdapter implements DBPort {

    public List<Consultant> getAllConsultants() {
        return InMemory.getInstance().getAllConsultants();
    }

    @Override
    public Consultant findById(Integer id) {
        return InMemory.getInstance().findById(id);
    }

    public Consultant saveConsultant(Consultant consultant) {
        InMemory.getInstance().saveConsultant(consultant);
        return consultant;
    }

}
