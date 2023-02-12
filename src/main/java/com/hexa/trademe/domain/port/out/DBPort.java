package com.hexa.trademe.domain.port.out;

import com.hexa.trademe.domain.domainclass.Consultant;

public interface DBPort {

    public static Consultant getInstance() {
        return null;
    }

    public Consultant saveConsultant(Consultant consultant);
}
