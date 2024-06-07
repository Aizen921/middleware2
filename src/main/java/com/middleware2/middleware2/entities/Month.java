package com.middleware2.middleware2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Month {
    @Id
    private Integer monthNumber;
    private String italianName;
    private String englishName;
    private String germanName;

    public Month(Integer monthNumber, String italianName, String englishName, String germanName) {
        this.monthNumber = monthNumber;
        this.italianName = italianName;
        this.englishName = englishName;
        this.germanName = germanName;
    }

    public Month() {
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(Integer monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getItalianName() {
        return italianName;
    }

    public void setItalianName(String italianName) {
        this.italianName = italianName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getGermanName() {
        return germanName;
    }

    public void setGermanName(String germanName) {
        this.germanName = germanName;
    }
}
