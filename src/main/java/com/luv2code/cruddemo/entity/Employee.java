package com.luv2code.cruddemo.entity;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.boot.registry.selector.StrategyRegistration;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    //Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lasstName;

    @Column(name = "email")
    private String email;

    //Define constructor

    public Employee() {
    }

    public Employee(String firstName, String lasstName, String email) {
        this.firstName = firstName;
        this.lasstName = lasstName;
        this.email = email;
    }
    //Define getter,setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasstName() {
        return lasstName;
    }

    public void setLasstName(String lasstName) {
        this.lasstName = lasstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //Define toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lasstName='" + lasstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
