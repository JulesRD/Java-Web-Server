package fr.epita.assistants.data.model;


import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "student_model")
public class StudentModel {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
public String name;
@ManyToOne @JoinColumn(name = "course_id") public CourseModel course_id;
}