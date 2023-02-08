package com.hexa.trademe.domain;

public class Consultant {
    private String name;
    public Consultant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "name='" + name + '\'' +
                '}';
    }
}
