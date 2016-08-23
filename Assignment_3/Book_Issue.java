package Assignment_3;

import java.sql.Date;

/**this is pojo class
 *which have getter and setter for book_issue's properties
 */
public class Book_Issue {

	private Date issue_dt;
	private Date due_dt;
	private int member_id;
	private int accession_no;

	public Date getIssue_dt() {
		return issue_dt;
	}

	public Date getDue_dt() {
		return due_dt;
	}

	public int getMember_id() {
		return member_id;
	}

	public int getAccession_no() {
		return accession_no;
	}

	public void setIssue_dt(Date issue_dt) {
		this.issue_dt = issue_dt;
	}

	public void setDue_dt(Date due_dt) {
		this.due_dt = due_dt;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public void setAccession_no(int accession_no) {
		this.accession_no = accession_no;
	}

}
