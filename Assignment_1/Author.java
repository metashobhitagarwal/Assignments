package Assignment_1;

/**this is POJO Class for author
 *contain getter setter method for author's properties
 */
public class Author implements Comparable<Author>{
	private int author_id;
	private String author_nm;

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_nm() {
		return author_nm;
	}

	public void setAuthor_nm(String author_nm) {
		this.author_nm = author_nm;
	}

	@Override
	public int compareTo(Author o) {
		return this.getAuthor_id() - o.getAuthor_id();
	}

}
