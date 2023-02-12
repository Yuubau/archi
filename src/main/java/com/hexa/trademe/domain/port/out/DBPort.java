package com.hexa.trademe.domain.port.out;

import com.hexa.trademe.domain.domainclass.Consultant;

import java.util.ArrayList;
import java.util.List;

public interface DBPort {

    public static Consultant getInstance() {
        return null;
    }

    public Consultant saveConsultant(Consultant consultant);

    public List<Consultant> getAllConsultants();

    public Consultant updateConsultant(Consultant consultant);


    Consultant findById(Integer id);
}
