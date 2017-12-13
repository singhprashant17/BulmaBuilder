package com.exmaple.bulma.model;

import com.prashant.java.bulmabuilder.BulmaBuilder;

@BulmaBuilder
public class FirstNameBean {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FirstNameBean{" +
                "type='" + type + '\'' +
                '}';
    }
}
