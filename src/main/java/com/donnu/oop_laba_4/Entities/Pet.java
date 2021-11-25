package com.donnu.oop_laba_4.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="pets")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "genus")
    private String genus;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private History med_history;

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Owner owner) {
        if(this.owners == null){
            this.owners = new ArrayList<>();
        }
        owners.add(owner);
    }

    @ManyToMany
    @JoinTable(
            name = "owner_pet",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    List<Owner> owners;

    public History getMed_history() {
        return med_history;
    }

    public void setMed_history(History med_history) {
        this.med_history = med_history;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Pet( String nickname, int age, String gender, String genus) {
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.genus = genus;
    }

    public Pet() {
    }
    @Override
    public String toString(){
        return String.format("Pet: ID = '%d', Nickname = '%s', Age = '%d', Gender = '%s', Genus = '%s'",
                this.id,
                this.nickname,
                this.age,
                this.gender,
                this.genus);
    }
}
