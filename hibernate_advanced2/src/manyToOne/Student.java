package manyToOne;
/*
 * 单向多对一:即可以从学生对象中获取自己所在的班级信息，但是不能
 * 通过班级对象中获取所有的学生信息
 */
public class Student {
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	Stu_Class stuClass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String sname) {
		this.name = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Stu_Class getStuClass() {
		return stuClass;
	}
	public void setStuClass(Stu_Class stuClass) {
		this.stuClass = stuClass;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", stuClass=" + stuClass
				+ "]";
	}
}
