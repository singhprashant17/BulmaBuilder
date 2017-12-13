package com.exmaple.bulma.model;

import com.prashant.java.bulmabuilder.BulmaBuilder;

import java.util.List;

@BulmaBuilder
public class ModelClass {
    private String title;
    private String type;
    private List<String> required;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }

    @Override
    public String toString() {
        return "ModelClass{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", required=" + required +
                '}';
    }
}
