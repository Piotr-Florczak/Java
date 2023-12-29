package com.example.spring3;

import lombok.Getter;

import java.util.List;
public class Family
{
    private final String uid;
    private String name;

    private List<Mamber> mambers;

    public Family(String uid, String name, List<Mamber> mambers) {
        this.uid = uid;
        this.name = name;
        this.mambers = mambers;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Mamber> getMambers() {
        return mambers;
    }

    public void setMambers(List<Mamber> mambers) {
        this.mambers = mambers;
    }
}
