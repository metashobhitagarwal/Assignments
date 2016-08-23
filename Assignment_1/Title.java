package Assignment_1;

/**this is POJO Class for Title
 *contain getter setter method for title's properties
 */
public class Title implements Comparable<Title> {

	private int title_id;
	private String title_nm;
	private int publisher_id;
	private int subject_id;

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public String getTitle_nm() {
		return title_nm;
	}

	public void setTitle_nm(String title_nm) {
		this.title_nm = title_nm;
	}

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	@Override
	public int compareTo(Title t) {
		return ((Integer) this.getTitle_id()).compareTo(((Integer) t.getTitle_id()));
	}

}
