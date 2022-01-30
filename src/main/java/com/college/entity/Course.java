package com.college.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Where(clause = "active = true")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "subscribe")
    private Boolean subscribe;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "is_selected")
    private Boolean isSelected;

    @OneToMany(mappedBy="course", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Subject.class)
    private List<Subject> subjectList = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "subject_id")
//    private Subject subject;


    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Course() {
    }

//    public Course(String name, Boolean subscribe, Boolean active, Boolean isSelected, List<Subject> subjectList, Lesson lesson) {
//        this.name = name;
//        this.subscribe = subscribe;
//        this.active = active;
//        this.isSelected = isSelected;
//        this.subjectList = subjectList;
//        this.lesson = lesson;
//    }

    public Course(Integer id, String name, Boolean active) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public List<Subject> getSubjectList() {
//        return subjectList;
//    }
//
//    public void setSubjectList(List<Subject> subjectList) {
//        this.subjectList = subjectList;
//    }


//    public Subject getSubject() {
//        return subject;
//    }
//
//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        this.subscribe = subscribe;
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }


}
