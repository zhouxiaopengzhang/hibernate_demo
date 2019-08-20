package oneToMany;

import java.util.Set;

public class Stu_Class3 {
	private Integer id;
	private String name;
	private Set<Student3> student3s;
	
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
	public Set<Student3> getStudent3s() {
		return student3s;
	}
	public void setStudent3s(Set<Student3> student3s) {
		this.student3s = student3s;
	}
	@Override
	public String toString() {
		return "Stu_Class3 [id=" + id + ", name=" + name + ", student3s=" + student3s + "]";
	}
	
}
