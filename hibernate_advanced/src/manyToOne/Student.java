package manyToOne;

import manyToOne.Teacher;

/*
 * Student与 Teacher类分别代表2个表，这两个表之间的关系是：一个teacher对应多个Student
 */
//Student是属于一对多中多的一端
public class Student {
	private Integer sid;
	private String sname;
	//关联指向一端的对象，一端无需关联多段
	private Teacher teacher;	//“多”的一端需要的类中需要有“一”的一端的对象字段
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", teacher=" + teacher + "]";
	}
	
	
}
