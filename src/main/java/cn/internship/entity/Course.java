package cn.internship.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	//主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	//课程名字
	private String name;
	//选课的老师
	@ManyToOne(targetEntity=Teacher.class)
	@JoinColumn(name="teacherId",referencedColumnName="teacherId",nullable=false)
	private Teacher teacher;
	//选课的学生集合
	@ManyToMany(targetEntity=Student.class)
	@JoinTable(name="student_course",
						joinColumns=@JoinColumn(name="courseId",referencedColumnName="courseId"),
						inverseJoinColumns=@JoinColumn(name="studentId",referencedColumnName="studentId"))
	private Set<Student> students = new HashSet<>();
	
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}