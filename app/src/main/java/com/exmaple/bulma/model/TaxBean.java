package com.exmaple.bulma.model;

import com.prashant.bulma.BulmaBuilder;

@BulmaBuilder
public class TaxBean {
    /**
     * name : VAT
     * value : 12.5
     */

    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
