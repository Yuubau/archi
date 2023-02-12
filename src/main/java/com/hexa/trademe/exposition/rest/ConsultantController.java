package com.hexa.trademe.exposition.rest;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.service.ConsultantService;
import com.hexa.trademe.adapter.rest.ConsultantRestAdapter;
import com.hexa.trademe.adapter.db.InMemoryDBAdapter;
import com.hexa.trademe.infrastructure.db.CreateConsultantRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultant")
public class ConsultantController {

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public Consultant createConsultant(@RequestBody CreateConsultantRequest req) {
        return new ConsultantService(new ConsultantRestAdapter(), new InMemoryDBAdapter())
                .createConsultant(req.firstName, req.lastName, req.skills, req.jobs, req.dailyRate);
    }
}
