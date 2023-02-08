package com.hexa.trademe.in;

import com.hexa.trademe.domain.Consultant;
import com.hexa.trademe.domain.ConsultantService;

public class ConsultantRestAdapter implements ConsultantPort {

    public Consultant create(String name) {
        return new Consultant(name);
    }
}
