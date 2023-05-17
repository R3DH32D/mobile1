package com.example.myapplication;

public class Comment {
    private Long description;
    private String text;


    private String student;

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Comment(String text, Long description, String student) {
        this.description = description;
        this.text = text;
        this.student = student;
    }

    public Comment(String text, String student) {
        this.text = text;
        this.student = student;
    }
    public Comment(){}
}
