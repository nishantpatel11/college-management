package com.college.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "video")
@Where(clause = "active = true")
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "is_selected")
    private Boolean isSelected;

    @Column(name = "link")
    private String urlLink;

    @OneToMany(mappedBy="video", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Lesson.class)
    private List<Lesson> lessonList = new ArrayList<>();


    @OneToMany(mappedBy="video", cascade = CascadeType.ALL)
    private List<Tag> tagList;


    public Video() {
    }

    public Video(String title, Boolean active, Boolean isSelected, String urlLink, List<Lesson> lessonList, List<Tag> tagList) {
        this.title = title;
        this.active = active;
        this.isSelected = isSelected;
        this.urlLink = urlLink;
        this.lessonList = lessonList;
        this.tagList = tagList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", active=" + active +
                ", isSelected=" + isSelected +
                ", urlLink='" + urlLink + '\'' +
                ", lessonList=" + lessonList +
                ", tagList=" + tagList +
                '}';
    }
}
