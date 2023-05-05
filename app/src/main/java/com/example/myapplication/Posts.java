package com.example.myapplication;

import lombok.Data;

@Data
public class Posts {
    private Long id;
    private String subjectName;
    private String teacherFIO;
    private String text;
    private String specLinks;

    public Posts(String subjectName, String teacherFIO, String text, String specLinks, String student) {
        this.subjectName = subjectName;
        this.teacherFIO = teacherFIO;
        this.text = text;
        this.specLinks = specLinks;
        this.student = student;
    }

//    public Posts(Posts post){
//        this.id = post.getId();
//        this.specLinks=post.;
//    }
    private String student;

    public Posts() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherFIO() {
        return teacherFIO;
    }

    public void setTeacherFIO(String teacherFIO) {
        this.teacherFIO = teacherFIO;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSpecLinks() {
        return specLinks;
    }

    public void setSpecLinks(String specLinks) {
        this.specLinks = specLinks;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Posts(Long id, String subjectName, String teacherFIO, String text, String specLinks, String student) {
        this.id = id;
        this.subjectName = subjectName;
        this.teacherFIO = teacherFIO;
        this.text = text;
        this.specLinks = specLinks;
        this.student = student;
    }
}