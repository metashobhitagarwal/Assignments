package Assignment_2;

import java.util.List;

import Assignment_1.Title;

/**this is responsible to 
 *display result and list of book and member
 */
public class DisplayResult {

	public void displayBook() {
		DBOperation dbo = new DBOperation();
		int counter = 0;
		List<Book> bookList = dbo.getBooks();
		List<Title> titleList = dbo.getTitles();

		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(++counter + " : "
					+ bookList.get(i).getAccession_no() + " : "
					+ titleList.get(i).getTitle_nm());
		}

	}

	public void displayMember() {
		DBOperation dbo = new DBOperation();
		int counter = 0;
		for (Member member : dbo.getMembers()) {
			System.out.println(++counter + " : " + member.getMember_nm());
		}
	}
}
