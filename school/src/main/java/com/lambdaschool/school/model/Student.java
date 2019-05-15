package com.lambdaschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;


@ApiModel(value = "Student", description = "The Student Entity")
@Entity
@Table(name = "student")
public class Student
{

    @ApiModelProperty(name = "studid", value = "primary key for Student", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studid;

    private String studname;

    @ManyToMany
    @Cascade({CascadeType.MERGE, CascadeType.SAVE_UPDATE})
    @JoinTable(name = "studcourses",
               joinColumns = {@JoinColumn(name = "studid")},
               inverseJoinColumns = {@JoinColumn(name = "courseid")})
    @JsonIgnoreProperties("students")
    private List<Course> courses = new ArrayList<>();

    public Student()
    {
    }

    public Student(String studname)
    {
        this.studname = studname;
    }

    public long getStudid()
    {
        return studid;
    }

    public void setStudid(long studid)
    {
        this.studid = studid;
    }

    public String getStudname()
    {
        return studname;
    }

    public void setStudname(String studname)
    {
        this.studname = studname;
    }

    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }
}
