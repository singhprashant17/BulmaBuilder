package com.exmaple.bulma.model;

import com.prashant.java.bulmabuilder.BulmaBuilder;

@BulmaBuilder
public class PropertiesBean {
    private FirstNameBean firstName;
    private LastNameBean lastName;
    private AgeBean age;

    public FirstNameBean getFirstName() {
        return firstName;
    }

    public void setFirstName(FirstNameBean firstName) {
        this.firstName = firstName;
    }

    public LastNameBean getLastName() {
        return lastName;
    }

    public void setLastName(LastNameBean lastName) {
        this.lastName = lastName;
    }

    public AgeBean getAge() {
        return age;
    }

    public void setAge(AgeBean age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PropertiesBean{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age +
                '}';
    }
}
