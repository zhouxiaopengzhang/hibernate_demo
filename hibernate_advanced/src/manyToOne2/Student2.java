package manyToOne2;
/*
 * Student与 Teacher类分别代表2个表，这两个表之间的关系是：一个teacher对应多个Student
 */
//Student是属于一对多中多的一端
public class Student2 {
	private Integer sid;
	private String sname;
	//关联指向一端的对象，一端无需关联多段
	private Teacher2 teacher2;	//“多”的一端需要的类中需要有“一”的一端的对象字段
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
	public Teacher2 getTeacher2() {
		return teacher2;
	}
	public void setTeacher2(Teacher2 teacher2) {
		this.teacher2 = teacher2;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", teacher2=" + teacher2 + "]";
	}
	
	
}
