package com.hexa.trademe.domain;

import com.hexa.trademe.in.ConsultantPort;

public class ConsultantService {
    public ConsultantPort port;

    public ConsultantService(ConsultantPort port){
        this.port = port;
    }

    public Consultant createConsultant(String name) {
        return port.create(name);
    }
}
