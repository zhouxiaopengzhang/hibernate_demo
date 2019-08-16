package oneToOne3;

/*单向一对一外键关联
 * 理解了主键关联，这个外键关系非常简单，因为他就是多对一的一个特例，如果多端控制为1个的话，那不
 * 就是一对一了吗，这里要注意站的角度问题，多对一重点在多端，如果是一对多的话，重点在一端，一端本来
 * 就是1了，就没有所谓的特例了，所以还是要到多端去设置让他唯一，这样就
 * 打到了一对一关系，因此上面说的是多对一的一个特例，这样解释应该清楚了。如何设置多端唯一呢，通过一个属性 unique=ture。
 * */
public class User3 {
	private Integer id;
	private String name;
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
	@Override
	public String toString() {
		return "User3 [id=" + id + ", name=" + name + "]";
	}
	
}
