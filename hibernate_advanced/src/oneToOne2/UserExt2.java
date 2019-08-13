package oneToOne2;

public class UserExt2 {
	//即是本表的主键也是user表的外键
	private Integer userId;
	private String idCardNum;
	private Integer sex;
	/*要依赖另外一个表，userExt扩展信息是基于user主表产生的，
	 * userExt主键id也是依赖于user主表
	 */
	private User2 user;
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
	public User2 getUser() {
		return user;
	}
	public void setUser(User2 user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserExt2 [userId=" + userId + ", idCardNum=" + idCardNum + ", sex=" + sex + ", user=" + user + "]";
	}
	
	
}
