package com.example.tatacliq.PersonalBasicsStuffs;

public class PersonalBasicStuffs {

    private int basicStuffs;
    private String name;
    private String description;
    private String descriptionTwo;
    private String explore;

    public PersonalBasicStuffs(int basicStuffs, String name, String description, String descriptionTwo, String explore) {
        this.basicStuffs = basicStuffs;
        this.name = name;
        this.description = description;
        this.descriptionTwo = descriptionTwo;
        this.explore = explore;


    }


    public int getBasicStuffs() {
        return basicStuffs;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionTwo() {
        return descriptionTwo;
    }

    public String getExplore() {
        return explore;
    }


}