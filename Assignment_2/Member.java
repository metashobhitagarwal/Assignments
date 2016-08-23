package Assignment_2;

/**this is POJO Class for Member
 *contain getter setter method for Member's properties
 */

public class Member {
	private int member_id;
	private String member_nm;
	private String addressLine1;
	private String addressLine2;
	private String Category ;
	public int getMember_id() {
		return member_id;
	}
	public String getMember_nm() {
		return member_nm;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCategory() {
		return Category;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public void setMember_nm(String member_nm) {
		this.member_nm = member_nm;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
	
}
