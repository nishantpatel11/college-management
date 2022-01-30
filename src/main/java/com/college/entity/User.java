package com.college.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    private String name;
    private Boolean isInstructor;
    private Boolean active;

    public User() {
    }


    public User(Integer userId, String name, Boolean isInstructor, Boolean active) {
        this.userId = userId;
        this.name = name;
        this.isInstructor = isInstructor;
        this.active = active;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInstructor() {
        return isInstructor;
    }

    public void setInstructor(Boolean instructor) {
        isInstructor = instructor;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", isInstructor=" + isInstructor +
                ", active=" + active +
                '}';
    }
}
