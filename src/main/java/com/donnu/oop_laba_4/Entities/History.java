package com.donnu.oop_laba_4.Entities;

import com.mysql.cj.xdevapi.JsonArray;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="histories")
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="dateOfApplication")
    private Date dateOfApplication;

    @Column(name="diagnosis")
    private String diagnosis;

    @Column(name="price")
    private int price;

    @Column(name="medicines")
    private String medicines;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;

    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public History( Date dateOfApplication, String diagnosis, int price, String medicines) {
        this.dateOfApplication = dateOfApplication;
        this.diagnosis = diagnosis;
        this.price = price;
        this.medicines = medicines;
    }

    public History() {
    }


    @Override
    public String toString(){
        return String.format("Medical History: ID = '%d', Date Of Application = '%s', Diagnosis = '%s', Price = '%d', Medicines = '%s'",
                this.id,
                this.dateOfApplication,
                this.diagnosis,
                this.price,
                this.medicines);
    }
}
