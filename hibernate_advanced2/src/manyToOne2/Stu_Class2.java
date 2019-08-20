package manyToOne2;

import java.util.Set;

public class Stu_Class2 {
	private Integer id;
	private String name;
	private Set<Student2> student2s;
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
	public Set<Student2> getStudent2s() {
		return student2s;
	}
	public void setStudent2s(Set<Student2> student2s) {
		this.student2s = student2s;
	}
	@Override
	public String toString() {
		return "Stu_Class2 [id=" + id + ", name=" + name + ", student2s=" + "]";
	}
	
	
}
