package PrinterJob;

import java.util.Scanner;

public class PrinterMain {

	public static void main(String[] args) {
		MyHeap heap = new MyHeap(20);
		Scanner scan = new Scanner(System.in);
		String operation[] = new String[] { "Add New Job", "Print Job", "Exit" };
		int pr;
		char ch = 0;
		do {
			int counter = 0;
			System.out.println("Operations : ");
			for (String opt : operation) {
				System.out.println(++counter + "." + opt);
			}
			System.out.println("Enter Your Choice : ");
			int choice = getChoice(counter);
			switch (choice) {
			case 1:
				System.out.println("Enter job name");
				String str = scan.next();
				System.out.print("Enter Priority Of " + str + "=");
				try {
					pr = scan.nextInt();
					heap.insert(str, pr);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Enter priority in integer only");
					main(args);
				}
				break;

			case 2:
				Job printJob = heap.remove();
				if (printJob != null)
					System.out.println(printJob.getName() + " of priority "
							+ printJob.getPriority() + " is printed");
				break;
				
			case 3:
				System.exit(0);
				break;
				
			default:
				System.out.println("Enter correct choice");
				main(args);
			}
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}

	// it takes users choice and return it
	static int getChoice(int range) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		try {
			do {
				choice = Integer.parseInt(scan.next());
			} while (choice <= 0 || choice > range);
		} catch (Exception e) {
			System.out.println("Invalid choice");
			getChoice(range);
		}
		return choice;
	}
}