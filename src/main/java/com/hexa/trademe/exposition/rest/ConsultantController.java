package com.hexa.trademe.exposition.rest;

import com.hexa.trademe.domain.domainclass.Consultant;
import com.hexa.trademe.domain.service.ConsultantService;
import com.hexa.trademe.adapter.rest.ConsultantRestAdapter;
import com.hexa.trademe.adapter.db.InMemoryDBAdapter;
import com.hexa.trademe.infrastructure.db.request.consultant.CreateConsultantRequest;
import com.hexa.trademe.infrastructure.db.request.consultant.SearchConsultantRequest;
import com.hexa.trademe.infrastructure.db.request.consultant.UpdateConsultantRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultant")
public class ConsultantController {

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public Consultant createConsultant(@RequestBody CreateConsultantRequest req) {
        return new ConsultantService(new ConsultantRestAdapter(), new InMemoryDBAdapter())
                .createConsultant(req.firstName, req.lastName, req.skills, req.jobs, req.dailyRate);
    }


    @PostMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public Consultant updateConsultant(@RequestBody UpdateConsultantRequest req) throws Exception {
        return new ConsultantService(new ConsultantRestAdapter(), new InMemoryDBAdapter())
                .updateConsultant(req.id,req.firstName, req.lastName, req.skills, req.dailyRate);
    }

    @GetMapping(value = "/search", produces = "application/json")
    @ResponseBody
    public List<Consultant> searchConsultant(@RequestBody SearchConsultantRequest req) {
        return new ConsultantService(new ConsultantRestAdapter(), new InMemoryDBAdapter())
                .searchConsultant(req.asSearch());
    }

}
