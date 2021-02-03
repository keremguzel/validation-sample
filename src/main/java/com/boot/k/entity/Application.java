package com.boot.k.entity;

import javax.persistence.*;

@Entity
@Table(name="applications_table")
public class Application {
    private Long id;
    private String applicantName;
    private Integer applicantSalary;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Integer getApplicantSalary() {
        return applicantSalary;
    }

    public void setApplicantSalary(Integer applicantSalary) {
        this.applicantSalary = applicantSalary;
    }

}
