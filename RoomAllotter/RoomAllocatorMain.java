package RoomAllotter;
import java.util.Scanner;

public class RoomAllocatorMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int roomSize = 0;
		int gSize = 0;
		String gName;
		int gAge = 0;

		/*
		 * Guest guest1 = new Guest("Rohit", 21); Guest guest2 = new
		 * Guest("Anjinkya", 22); Guest guest3 = new Guest("Sanjiv", 24); Guest
		 * guest4 = new Guest("Abhishek", 22); Guest guest5 = new
		 * Guest("Rakesh", 29);
		 */

		try {
			System.out.println("Enter no of Rooms=");
			roomSize = sc.nextInt();
			Room room[] = new Room[roomSize];
			createRoom(roomSize, room);

			MyHashTable hash = new MyHashTable(roomSize, room);

			System.out.println("Enter no of guests=");
			gSize = sc.nextInt();
			Guest gArray[] = new Guest[gSize];

			for (int index = 0; index < gSize; index++) {
				System.out.print("Enter guest" + (index + 1) + " name=");
				gName = sc.next();
				System.out.print("Enter guest" + (index + 1) + " age=");
				gAge = sc.nextInt();
				System.out.println();
				gArray[index] = new Guest(gName, gAge);
			}

			System.out.println("\nAllocating Rooms to all guests");

			for (int index = 0; index < gSize; index++) {
				hash.allocateRoom(gArray[index]);
			}

			/*
			 * hash.insert(guest1); hash.insert(guest3); hash.insert(guest2);
			 * hash.insert(guest5); hash.insert(guest4);
			 */

			hash.printDetail();

		} catch (Exception e) {
			System.out.println("Enter correct input");
			main(args);
		}
	}

	static public void createRoom(int count, Room room[]) {
		for (int index = 0; index < count; index++) {
			room[index] = new Room(100 + index);
		}
	}

}