package oneToOne3;

/*单向一对一外键关联*/
public class UserExt3 {
	//即是本表的主键也是user表的外键
		private Integer id;
		private String idCardNum;
		private Integer sex;
		/*要依赖另外一个表，userExt扩展信息是基于user主表产生的，
		 * userExt主键id也是依赖于user主表
		 */
		private User3 user;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
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
		public User3 getUser() {
			return user;
		}
		public void setUser(User3 user) {
			this.user = user;
		}
		@Override
		public String toString() {
			return "UserExt3 [id=" +id + ", idCardNum=" + idCardNum + ", sex=" + sex + "]";
		}
		
}
