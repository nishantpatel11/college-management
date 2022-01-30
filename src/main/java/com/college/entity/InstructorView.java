package com.college.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


public class InstructorView implements Serializable {


    private List<Video> videos;
    private List<Course> courses;


    public InstructorView() {
    }

    public InstructorView(List<Video> videos, List<Course> courses) {
        this.videos = videos;
        this.courses = courses;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "InstructorView{" +
                "videos=" + videos +
                ", courses=" + courses +
                '}';
    }
}
