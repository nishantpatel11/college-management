package com.college.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "is_selected")
    private Boolean isSelected;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

//    @OneToMany(mappedBy="subject", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Course.class)
//    private List<Course> courseList = new ArrayList<>();


    public Subject() {
    }

//    public Subject(String name, Boolean active, Boolean isSelected, Course course) {
//        this.name = name;
//        this.active = active;
//        this.isSelected = isSelected;
//        this.course = course;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }


}
