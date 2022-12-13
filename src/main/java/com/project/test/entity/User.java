package com.project.test.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonManagedReference
    private UserContact userContact;


    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserContact getUserContact() {
        return userContact;
    }

    public void setUserContact(UserContact userContact) {
        this.userContact = userContact;
    }
}
