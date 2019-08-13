package oneToOne;

public class UserExt {
	//即是本表的主键也是user表的外键
	private Integer userId;
	private String idCardNum;
	private Integer sex;
	/*要依赖另外一个表，userExt扩展信息是基于user主表产生的，
	 * userExt主键id也是依赖于user主表
	 */
	private User user;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
