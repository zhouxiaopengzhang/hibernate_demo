package manyToOne2;

import java.util.Set;
/*
 * Student与 Teacher类分别代表2个表，这
 * 两个表之间的关系是：一个teacher对应多个Student
 */
public class Teacher2 {
	private Integer tid;
	private String tname;
	//一个教师对应多个学生，使用set原因是set的内容不能重复
	private Set<Student2> studentSet;
	
	public Set<Student2> getStudentSet() {
		return studentSet;
	}
	public void setStudentSet(Set<Student2> studentSet) {
		this.studentSet = studentSet;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + "]";
	}
	
}
