package Assignment_1;

/**this is POJO Class for Title_Author
 *contain getter setter method for Title_Authro's properties
 */
public class Title_Author implements Comparable<Title_Author> {

	private int title_id;
	private int authors_id;

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public int getAuthors_id() {
		return authors_id;
	}

	public void setAuthors_id(int authors_id) {
		this.authors_id = authors_id;
	}

	@Override
	public int compareTo(Title_Author o) {
		if((this.getTitle_id() - o.getTitle_id()) == 0){
			if((this.getAuthors_id()- o.getAuthors_id()) == 0){
				return 0;
			}
		}
		return 1;
	}

}
