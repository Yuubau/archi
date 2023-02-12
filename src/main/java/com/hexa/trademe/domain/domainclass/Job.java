package com.hexa.trademe.domain.domainclass;

import java.util.Date;

public class Job {
    private Integer id;
    private Date date;
    private Integer days;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Job(Date date, Integer days) {
        this.date = date;
        this.days = days;
    }


}
