package manyToMany;

import java.util.Set;
/*单向多对多只需要在其中的一个类中添加set集合*/
public class Course5 {
	private Integer id;
	private String name;
	private Set<Student5> students;
	
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
	public Set<Student5> getStudents() {
		return students;
	}
	public void setStudents(Set<Student5> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course5 [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
}
