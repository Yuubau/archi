package com.hexa.trademe.rest;

import com.hexa.trademe.domain.Consultant;
import com.hexa.trademe.domain.ConsultantService;
import com.hexa.trademe.in.ConsultantPort;
import com.hexa.trademe.in.ConsultantRestAdapter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultant")
public class ConsultantController {

    @GetMapping(value = "/create/{name}", produces = "application/json")
    @ResponseBody
    public Consultant getFoosBySimplePath(@PathVariable String name) {
        return new ConsultantService(new ConsultantRestAdapter()).createConsultant(name);
    }
}
