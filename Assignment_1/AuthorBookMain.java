package Assignment_1;

import java.util.List;
import java.util.Scanner;


public class AuthorBookMain {

	public static void main(String[] args) {
		DBOperation dbOpt = new DBOperation();
		List<Author> authorList = dbOpt.getAuthors();
		Scanner scan = new Scanner(System.in);
		char ch = 0;
		do {
			int counter = 0;

			for (Author author : authorList) {
				System.out.println(++counter + " : " + author.getAuthor_nm());
			}

			System.out.println("Enter Choice : ");
			int choice = 0;
			do {
				choice = scan.nextInt();
			} while (choice < 1 || choice > 25);

			ResultDisplay resDis = new ResultDisplay();
			resDis.displayResult(authorList.get(choice - 1));

		} while (ch == 'Y' && ch == 'y');
		
		scan.close();
	}

}
