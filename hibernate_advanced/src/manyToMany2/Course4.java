package manyToMany2;
import java.util.Set;

public class Course4 {
	private Integer id;
	private String name;
	private Set<Student4> students;
	
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
	public Set<Student4> getStudents() {
		return students;
	}
	public void setStudents(Set<Student4> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course4 [id=" + id + ", name=" + name +"]";
	}
	
}
