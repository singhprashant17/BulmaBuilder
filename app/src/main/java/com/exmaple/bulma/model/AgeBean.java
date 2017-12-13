package com.exmaple.bulma.model;

import com.prashant.java.bulmabuilder.BulmaBuilder;

@BulmaBuilder
public class AgeBean {
    private String description;
    private String type;
    private int minimum;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    @Override
    public String toString() {
        return "AgeBean{" +
                "description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", minimum=" + minimum +
                '}';
    }
}
