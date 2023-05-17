package com.example.myapplication;

public class User {
    private Long id;
    private String groups;
    private String name;
    private String lastName;
    private String login;
    private String password;

public User(){};
    public User(String groups, String name, String lastName, String login, String password) {
        this.id = id;
        this.groups = groups;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }
    public User( String login, String password) {

        this.login = login;
        this.password = password;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
