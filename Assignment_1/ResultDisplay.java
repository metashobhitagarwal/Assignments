package Assignment_1;

//this class is responsible to display results
public class ResultDisplay {

	public void displayResult(Author author) {

		DBOperation dbo = new DBOperation();
		dbo.authorBookDetail(author);
		
		//iterate booklist and respective titlelist
		for (Book objBook : dbo.getBookList()) {
			for (Title objTitle : dbo.getTitleList()) {
				if (objBook.getTitle_id() == objTitle.getTitle_id()) {
					System.out.println("" + objBook.getAccession_no() + " "
							+ objTitle.getTitle_nm() + " "
							+ objBook.getPurchase_dt());
				}
			}
		}
	}

}
