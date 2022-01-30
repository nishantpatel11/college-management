package com.college.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "view")
public class View implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "refId")
    private Integer refId;

    public View() {
    }

    public View( String type, LocalDateTime createDate, Integer refId) {
        this.type = type;
        this.createDate = createDate;
        this.refId = refId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    @Override
    public String toString() {
        return "View{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                ", refId=" + refId +
                '}';
    }
}
