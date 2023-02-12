package com.hexa.trademe.adapter.db;

import com.hexa.trademe.domain.port.out.DBPort;
import com.hexa.trademe.infrastructure.db.InMemory;
import com.hexa.trademe.domain.domainclass.Consultant;

public class InMemoryDBAdapter implements DBPort {

    public Consultant saveConsultant(Consultant consultant) {
        InMemory.getInstance().saveConsultant(consultant);
        return consultant;
    }
}
