package manyToMany2;

import java.util.Set;

public class Student4 {
	private Integer id;
	private String name;
	private Set<Course4> courses;
	
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
	public Set<Course4> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course4> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student4 [id=" + id + ", name=" + name + "]";
	}
	
}
