package com.codeclanlab.example.employeetracking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "employee_num")
    private String employeeNum;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name="department_id", nullable= false)
    @JsonIgnoreProperties({"employees"})

    private Department department;


    public Employee(String name, int age, String employeeNum, String email, Department department) {
        this.name = name;
        this.age = age;
        this.employeeNum = employeeNum;
        this.email = email;
        this.department = department;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employee_num) {
        this.employeeNum = employee_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
