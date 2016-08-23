package Assignment_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.mysql.jdbc.Statement;

public class DBOperation {

	//it retrive list of books which were purchesd one year ago
	List<Book> getBooks() {

		PreparedStatement pst = null;
		ResultSet rst = null;
		List<Book> bookListAll = new ArrayList<Book>();
		Connection con = new DBConnection().getConnection();
		
		//sql query for retrive books which were purchesd one year ago
		String sql = "Select * from books where datediff(now(),purchase_dt)>365";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();

			while (rst.next()) {
				Book objBook = new Book();
				objBook.setAccession_no(rst.getInt(1));
				objBook.setTitle_id(rst.getInt(2));
				objBook.setPurchase_dt(rst.getDate(3));
				objBook.setPrice(rst.getFloat(4));
				objBook.setStatus(rst.getString(5));
				bookListAll.add(objBook);
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
		return bookListAll;
	}// close getAuthor()

	//logic to find books which were not issued in last 1 year
	public void checkAssignedTime() {

		PreparedStatement pst = null;
		ResultSet rst = null;
		List<Book> bookListAll = getBooks();
		Connection con = new DBConnection().getConnection();

		try {
			for (Book book : bookListAll) {
				pst = con.prepareStatement("select issue_dt ,datediff(now(),issue_dt)  from book_issue where accession_no = ? order by issue_dt desc ");
				pst.setInt(1, book.getAccession_no());

				rst = pst.executeQuery();
				if (rst.next()) {
					if (rst.getInt(2) > 365) {	//book not issued in 1 year
						deleteUnassignedBook(book);		//delete book
						continue;
					}
				} else {		//book not issued yet and  which were purchesd one year ago 
					deleteUnassignedBook(book);
					continue;
				}
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

	}

	
	//delete given book
	public void deleteUnassignedBook(Book book) {

		PreparedStatement pst = null;
		int result = 0;

		Connection con = new DBConnection().getConnection();
		String sql = "delete from books where accession_no = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, book.getAccession_no());
			result = pst.executeUpdate();

			if (result > 0) {
				System.out.println(" Accession No :" + book.getAccession_no()
						+ " Deleted");
			} else {
				System.out.println(" Accession No :" + book.getAccession_no()
						+ " Not Deleted");
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

	}// close getAuthor()
}
