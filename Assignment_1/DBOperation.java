package Assignment_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DBOperation {

	Set<Author> authorList = new TreeSet<Author>();
	Set<Title_Author> titleAuthorList = new TreeSet<Title_Author>();
	Set<Title> titleList = new TreeSet<Title>();
	Set<Book> bookList = new TreeSet<Book>();

	List<Author> getAuthors() {

		PreparedStatement pst = null;
		ResultSet rst = null;
		List<Author> authorListAll = new ArrayList<Author>();
		Connection con = new DBConnection().getConnection();
		String sql = "Select * from authors";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();

			while (rst.next()) {
				Author obj = new Author();
				obj.setAuthor_id(rst.getInt(1));
				obj.setAuthor_nm(rst.getString(2));
				authorListAll.add(obj);
			}
		} catch (SQLException e) {
			System.out.println(" SQL Error : " + e);
		} finally {
			try {
				con.close();
				pst.close();
				rst.close();
			} catch (SQLException e) {
				System.out.println(" SQL Exception on Close :" + e);
			}
		}
		return authorListAll;
	}// close getAuthor()

	public void getAuthor_Book(Author author) {

		PreparedStatement pst = null;
		ResultSet rst = null;
		List<Author> authorList = new ArrayList<Author>();
		Connection con = new DBConnection().getConnection();
		String sql = "Select * from authors";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();

			while (rst.next()) {
				Author obj = new Author();
				obj.setAuthor_id(rst.getInt(1));
				obj.setAuthor_nm(rst.getString(2));
				authorList.add(obj);
			}
		} catch (SQLException e) {
			System.out.println(" SQL Error : " + e);
		} finally {
			try {
				con.close();
				pst.close();
				rst.close();
			} catch (SQLException e) {
				System.out.println(" SQL Exception on Close :" + e);
			}
		}
	}// close getAuthor_Book()

	//It contains logic to get detail of choosed author
	public void authorBookDetail(Author author) {

		int author_id = author.getAuthor_id();
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		
		Connection con = new DBConnection().getConnection();
		
		//sql query for retrive books of desired author
		String sql = "select * from authors a" + " inner join title_authors au"
				+ " on au.authors_id = a.authors_id" + " inner join title t"
				+ " on t.title_id = au.title_id" + " inner join books b"
				+ " on b.title_id = t.title_id" + " where a.authors_id = ? ";

		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, author_id);
			rst = pst.executeQuery();
			while (rst.next()) {
				
				//save result into respective pojo class and also add in list
				
				Author obj = new Author();
				obj.setAuthor_id(rst.getInt(1));
				obj.setAuthor_nm(rst.getString(2));
				if(!authorList.contains(obj)){
				authorList.add(obj);
				}

				Title_Author objTitleAuthor = new Title_Author();
				objTitleAuthor.setTitle_id(rst.getInt(3));
				objTitleAuthor.setAuthors_id(rst.getInt(4));
				if(!titleAuthorList.contains(objTitleAuthor)){
				titleAuthorList.add(objTitleAuthor);
				}

				Title objTitle = new Title();
				objTitle.setTitle_id(rst.getInt(5));
				objTitle.setTitle_nm(rst.getString(6));
				objTitle.setPublisher_id(rst.getInt(7));
				objTitle.setSubject_id(rst.getInt(8));
				if(!titleList.contains(objTitle)){
				titleList.add(objTitle);
				}

				Book objBook = new Book();
				objBook.setAccession_no(rst.getInt(9));
				objBook.setTitle_id(rst.getInt(10));
				objBook.setPurchase_dt(rst.getDate(11));
				objBook.setPrice(rst.getFloat(12));
				objBook.setStatus(rst.getString(13));
				if (!bookList.contains(objBook)) {
					bookList.add(objBook);
				}

			}
		} catch (SQLException e) {
			System.out.println(" SQL Error : " + e);
		} finally {
			try {
				con.close();
				pst.close();

			} catch (SQLException e) {
				System.out.println(" SQL Exception on Close :" + e);
			}
		}
	}

	public Set<Author> getAuthorList() {
		return authorList;
	}

	public Set<Title_Author> getTitleAuthorList() {
		return titleAuthorList;
	}

	public Set<Title> getTitleList() {
		return titleList;
	}

	public Set<Book> getBookList() {
		return bookList;
	}

}
