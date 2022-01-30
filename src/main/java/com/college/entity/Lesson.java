package com.college.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
@Where(clause = "active = true")
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "is_selected")
    private Boolean isSelected;

    @OneToMany(mappedBy="lesson", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Course.class)
    private List<Course> courseList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    public Lesson() {
    }

    public Lesson(String name, Boolean active, Boolean isSelected, List<Course> courseList, Video video) {
        this.name = name;
        this.active = active;
        this.isSelected = isSelected;
        this.courseList = courseList;
        this.video = video;
    }

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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", isSelected=" + isSelected +
                ", courseList=" + courseList +
                ", video=" + video +
                '}';
    }
}
