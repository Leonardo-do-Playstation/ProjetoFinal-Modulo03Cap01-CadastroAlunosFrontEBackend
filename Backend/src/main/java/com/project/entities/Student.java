package com.project.entities;

public class Student {
    
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Integer idCurso;
    private Integer period;

    public Student() {

    }

    public Student(Integer id, String name, String email, String phone, Integer idCurso, Integer period) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idCurso = idCurso;
        this.period = period;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    
}
