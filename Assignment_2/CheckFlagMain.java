package Assignment_2;

import java.util.Scanner;

public class CheckFlagMain {

	public static void main(String[] args) {
		char ch = 0;
		Scanner scan = new Scanner(System.in);
		DisplayResult dr = new DisplayResult();
		DBOperation dbo = new DBOperation();
		do {
			dr.displayBook();
			int bookChoice = 0;
			do {
				System.out.println("enter book id: ");
				bookChoice = scan.nextInt();
			} while (bookChoice < 1 && bookChoice > dbo.getBooks().size());
			dr.displayMember();
			int memChoice = 0;
			do {
				System.out.println("enter member id: ");
				memChoice = scan.nextInt();
			} while (memChoice < 1 && memChoice > dbo.getMembers().size());

			if (dbo.isBookIssued(dbo.getMembers().get(memChoice - 1), dbo
					.getBooks().get(bookChoice - 1))) {
				System.out.println("Book is Issued & Not Available");
			} else {
				System.out.println("Not Issued & Available");
			}
			System.out.println("For Continue Enter  Y or y ");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

		scan.close();
	}

}
