package oneToOne2;
/*由于需要双向一对一，即需要双向访问，因此需要在原来的User类
 * 基础上添加一个UserExt类型的成员，并将类名修改为User2
 * */
public class User2 {
	private Integer userId;
	private String userName;
	private UserExt2 ext;
	
	public UserExt2 getExt() {
		return ext;
	}
	public void setExt(UserExt2 ext) {
		this.ext = ext;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User2 [userId=" + userId + ", userName=" + userName + "]";
	}

}
