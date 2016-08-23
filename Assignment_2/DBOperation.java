package Assignment_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Assignment_1.Title;

public class DBOperation {

	
	//retrive book list
	List<Book> getBooks() {

		PreparedStatement pst = null;
		ResultSet rst = null;
		List<Book> bookListAll = new ArrayList<Book>();
		Connection con = new DBConnection().getConnection();
		String sql = "Select * from books";
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

	//retrive member list
	public List<Member> getMembers() {

		PreparedStatement pst = null;
		ResultSet rst = null;
		List<Member> memberListAll = new ArrayList<Member>();
		Connection con = new DBConnection().getConnection();
		String sql = "Select * from members";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();

			while (rst.next()) {
				Member objMember = new Member();
				objMember.setMember_id(rst.getInt(1));
				objMember.setMember_nm(rst.getString(2));
				objMember.setAddressLine1(rst.getString(3));
				objMember.setAddressLine2(rst.getString(4));
				objMember.setCategory(rst.getString(5));
				memberListAll.add(objMember);
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
		return memberListAll;
	}

	//retrive title
	List<Title> getTitles() {

		PreparedStatement pst = null;
		ResultSet rst = null;
		List<Title> titleListAll = new ArrayList<Title>();
		Connection con = new DBConnection().getConnection();
		String sql = "Select * from title";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();

			while (rst.next()) {
				Title objTitle = new Title();
				objTitle.setTitle_id(rst.getInt(1));
				objTitle.setTitle_nm(rst.getString(2));
				objTitle.setPublisher_id(rst.getInt(3));
				objTitle.setSubject_id(rst.getInt(4));
				titleListAll.add(objTitle);
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
		return titleListAll;
	}

	
	//logic to check whether book is issued or avail for issue
	public boolean isBookIssued(Member member, Book book) {

		boolean flag = false;
		PreparedStatement pst = null;
		ResultSet rst = null;

		Connection con = new DBConnection().getConnection();
		
		//sql query to find out the book_issue detail using inner join
		String sql = "select bi.issue_dt , br.return_date from book_issue bi"
				+ " left join book_return br "
				+ " on bi.issue_dt = br.issue_dt && bi.member_id = br.member_id && br.accession_no = bi.accession_no"
				+ " where bi.accession_no = ?" + " order by bi.issue_dt desc ";

		try {
			pst = con.prepareStatement(sql);

			pst.setInt(1, book.getAccession_no());
			rst = pst.executeQuery();

			if (rst.next()) {
				if (rst.getDate(2) != null) { //if book is not returned
					flag = false;
					return flag;
				} else {   				// book is returned
					flag = true;
					return flag;
				}
				
			} else {		//books which is not issued till now
				flag = false;
				return flag;
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
		return flag;
	}

}
