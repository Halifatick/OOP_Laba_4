package com.donnu.oop_laba_4.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="doctors")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "position")
    private String position;

    @Column(name = "experienceInYears")
    private int experienceInYears;

    // FetchType.EAGER
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // FetchType.LAZY
    //@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<History> history;

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(History history) {
        if(this.history == null){
            this.history = new ArrayList<>();
        }
        this.history.add(history);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public Doctor(String fio, String position, int experienceInYears) {
        this.fio = fio;
        this.position = position;
        this.experienceInYears = experienceInYears;
    }

    public Doctor() {
    }

    @Override
    public String toString(){
        return String.format("Doctor: ID = '%d', FIO = '%s', Experience in years = '%d', Position = '%s'",
                this.id,
                this.fio,
                this.experienceInYears,
                this.position);
    }
}
