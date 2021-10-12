package com.codeclanlab.example.employeetracking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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



    @ManyToMany
    @JsonIgnoreProperties({"employees"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name="employee_projects",
            joinColumns = {@JoinColumn(
                    name="employee_id",
                    nullable= false,
                    updatable = false)
            },
            inverseJoinColumns = {@JoinColumn(
                    name="project_id",
                    nullable = false,
                    updatable = false)
            }
    )

    private List<Project> projects;


    public Employee(String name, int age, String employeeNum, String email, Department department) {
        this.name = name;
        this.age = age;
        this.employeeNum = employeeNum;
        this.email = email;
        this.department = department;
        this.projects = new ArrayList<>();
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }
}
