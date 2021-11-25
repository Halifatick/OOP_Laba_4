package com.donnu.oop_laba_4.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="owners")
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="fio")
    private String fio;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(Pet pet) {
        if(this.pets == null){
            this.pets = new ArrayList<>();
        }
        this.pets.add(pet);
    }

    @ManyToMany
    @JoinTable(
            name = "owner_pet",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    List<Pet> pets;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Owner( String fio, String phone, String address) {
        this.fio = fio;
        this.phone = phone;
        this.address = address;
    }

    public Owner() {
    }


    @Override
    public String toString(){
        return String.format("Owner: ID = '%d', FIO = '%s', PhoneNumber = '%s', Address = '%s'",
                this.id,
                this.fio,
                this.phone,
                this.address);
    }
}
