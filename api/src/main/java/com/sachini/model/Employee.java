package com.sachini.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMP_TBL")
public class Employee implements Serializable {

    private static final long serialVersionUID = -3465813074586302847L;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String telephone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}