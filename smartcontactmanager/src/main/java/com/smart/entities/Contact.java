package com.smart.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId;

    private String name;

    private String secondName;

    private String work;

    private String email;

    private String phone;

    private String image;

    @Column(length = 5000)
    private String description;

    @ManyToOne
    private User user;

    public Integer getcId() {
        return cId;
    }

    public Contact setcId(Integer cId) {
        this.cId = cId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getSecondName() {
        return secondName;
    }

    public Contact setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public String getWork() {
        return work;
    }

    public Contact setWork(String work) {
        this.work = work;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Contact setImage(String image) {
        this.image = image;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Contact setUser(User user) {
        this.user = user;
        return this;
    }
}
